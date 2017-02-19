package com.deep.two.controller.authority;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.deep.two.authority.helper.ButtonControlRepository;
import com.deep.two.authority.model.ButtonModel;
import com.deep.two.authority.model.CurrentUser;
import com.deep.two.authority.model.UserExtend;
import com.deep.two.dao.CommonDAO;
import com.deep.two.model.query.authority.UserQueryModel;
import com.deep.two.model.query.companyUser.CompanyUserCombineQueryModel;
import com.deep.two.model.query.investorUser.InvestorUserCombineQueryModel;
import com.deep.two.model.query.researchUser.ResearchUserQueryModel;
import com.deep.two.model.result.HiddenModel;
import com.deep.two.util.CopyUtil;
import com.deep.two.util.JSONUtil;
import com.deep.two.util.ViewException;

@RequestMapping("security")
@Controller
public class SecurityController {
    
    @Autowired
    @Qualifier("buttonControlRepository")
    private ButtonControlRepository bcr;
    
    @Autowired
    private CommonDAO commonDAO;
    
    /**
     * forwardLoginPage:登录页面 <br/>
     * @param flag
     *            用户名密码错误标识flag
     * @return ModelAndView 返回页面
     */
    @RequestMapping("loginPage")
    @ResponseBody
    public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="flag", required=false) String flag) {
        ModelAndView modelAndView = new ModelAndView("authority/login");
        // 用户名密码错误标识flag
        modelAndView.addObject("flag", flag);
        modelAndView.addObject("j_username", request.getParameter("j_username"));
        modelAndView.addObject("j_password", request.getParameter("j_password"));
        return modelAndView;
    }
    
    @RequestMapping("homepage")
    @ResponseBody
    public ModelAndView homepage() {
        return new ModelAndView("homepage/homepage");
    }
    
    @RequestMapping("register")
    @ResponseBody
    public ModelAndView registor() {
        return new ModelAndView("authority/register");
    }
    
    @RequestMapping("researchUserRegister")
    @ResponseBody
    public ModelAndView researchUserRegister() {
        return new ModelAndView("authority/researchUserRegister");
    }
    
    @RequestMapping("companyUserRegister")
    @ResponseBody
    public ModelAndView companyUserRegister() {
        return new ModelAndView("authority/companyUserRegister");
    }
    
    @RequestMapping("investorUserRegister")
    @ResponseBody
    public ModelAndView investorUserRegister() {
        return new ModelAndView("authority/investorUserRegister");
    }

    /**
     * forwardNorightPage: Description <br/>
     * @return ModelAndView 返回页面
     */
    @RequestMapping("noRightPage")
    @ResponseBody
    public ModelAndView forwardNorightPage() {
        return new ModelAndView("authority/noright");
    }
    
    @RequestMapping("alreadyLogin")
    @ResponseBody
    public ModelAndView alreadyLogin() {
        return new ModelAndView("/authority/alreadyLoginPage");
    }
    
  //找回密码
    @RequestMapping("findPasswordPage")
    @ResponseBody
    public ModelAndView findPasswordPage() {
        return new ModelAndView("authority/forgotPassword");
    }
    
    @RequestMapping("submitPasswordPage")
    @ResponseBody
    public ModelAndView submitPasswordPage() {
        return new ModelAndView("authority/submitPassword");
    }
    //关于我们
    @RequestMapping("aboutusPage")
    @ResponseBody
    public ModelAndView aboutusPage() {
        return new ModelAndView("homepage/aboutus");
    }

    @RequestMapping("getCurrentUser")
    @ResponseBody
    public CurrentUser getCurrentUser() {
		CurrentUser model = null;
    	try {
    		Authentication au =  SecurityContextHolder.getContext().getAuthentication();
    		if (au.isAuthenticated() && au.getPrincipal() !=null && !"anonymousUser".equals(au.getPrincipal())) {
    			UserExtend user = (UserExtend)au.getPrincipal();
    			UserQueryModel uqm = new UserQueryModel();
    			uqm.setId(user.getId());
    			user.setCompanyUserModels(this.commonDAO.queryCompanyUserList(new CompanyUserCombineQueryModel(uqm, null)));
    			user.setInvestorUserModels(this.commonDAO.queryInvestorUserList(new InvestorUserCombineQueryModel(uqm, null)));
    			user.setResearchUserModels(this.commonDAO.queryResearchUserList(new ResearchUserQueryModel(uqm, null, null)));
    			model = CopyUtil.copyProperty(user, CurrentUser.class);
    		}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
    
    @RequestMapping("getHiddenList")
    @ResponseBody
    public List<ButtonModel> getHiddenList(@RequestParam("str")String str) {
        List<ButtonModel> bmList = null;
        HiddenModel model = null;
        try {
            model = JSONUtil.jsonToModel(str, HiddenModel.class, null);
            bmList = bcr.getHiddenList(model.getList(), model.getUserId());
        } catch (ViewException e) {
            e.printStackTrace();
        } 
        return bmList;
    }
    
    @RequestMapping("forgotPassword")
    @ResponseBody
    public ModelAndView forgotPassword() {
        return new ModelAndView("/authority/forgotPassword");
    }
	
	    
    //注册界面点击注册协议连接
    @RequestMapping("registAgreement")
    @ResponseBody
    public ModelAndView registAgreement() {
    	ModelAndView model=new ModelAndView("homepage/aboutus");
    	model.addObject("registAgreement", "true");
        return model;
    }
    
    
    // 页脚 联系我们连接
    @RequestMapping("callUs")
    @ResponseBody
    public ModelAndView callUs() {
    	ModelAndView model=new ModelAndView("homepage/aboutus");
    	model.addObject("callUs", "true");
        return model;
    }
    
    
    
    //页脚 信息发布连接
    @RequestMapping("infoPublish")
    @ResponseBody
    public ModelAndView infoPublish() {
    	ModelAndView model=new ModelAndView("homepage/aboutus");
    	model.addObject("infoPublish", "true");
        return model;
    }
}
