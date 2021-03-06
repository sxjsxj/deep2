<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/head.jsp" %>
<title>关于我们</title>
</head>
<body>
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>

	<input type="text"  id="registAgreement" value="${registAgreement}"/>

	<!--控制页脚连接  联系我们,信息发布 -->
	<input type="text"  id="callUs" value="${callUs}"/>
	<input type="text"  id="infoPublish" value="${infoPublish}"/>

	<div class='cons aboutus' style="margin-top:80px;">
		<div class='width1200'>
			<div class='fl l_toul'>
				<ul>
					<li class='active' id="navAboutUs"><a href=''>关于我们</a></li>
					<li id="navCallUs"><a>联系我们</a></li>
					<li id="navJoin"><a>信息发布</a></li>
					<!-- <li id="navExplian"><a>服务说明</a></li> -->
					<li id="navAgreement"><a>注册协议</a></li>
				</ul>
			</div>
			<div class='fl cn' id="divAboutUs">
				<div class='cn_ti'>关于我们</div>
				<div class='ims'><img src='${pageContext.request.contextPath}/resources/images/front/img/ims.png' width="100%" /></div>
				<div class='cn_t'>好的科技成果，如何进行市场化？如何找到资金？如何被市场认可？如何实现价值最大化？
企业的产业和产品升级，如何插上技术创新的翅膀？如何提升自己的研发水平？如何解决技术难题？如何在日新月异的技术进步面前持续增长？
作为投资人，如何找到好的项目？如何找到新的科研成果？如何为投资找到领先的商机？</div>
				<div class='cn_t'>联科，想你所想，让远见有力量。
我们，将解决企业、科研机构、投资方的沟通问题，我们要做的就是将各方的优质资源进行整合。采取市场化运营的方式，为高校、科研机构的科技成果转化提供更加高水平、专业化和系统化的服务。让聪明的创造，变为智慧的应用。</div>
				<div class='cn_t'>解决如下问题：
沟通渠道问题——提供沟通平台：资源丰富，快速定位
沟通方式问题——提供一对一服务机制：专业，高效
合作模式问题——打造供需模式：企业需求、科研项目、资金无缝对接</div>
				<div class='cn_t'>提供如下服务：
推动企业生产技术升级和创新——帮助企业解决生产、转型中的技术难题
推动科研项目产业化——推动高校、科研机构的科技项目市场转化
资本对接——提供科技创业项目资本的对接服务
团队人才对接——创业就业人才团队对接搭建</div>
				<div class='cn_t'>我们的优势：
①定位清晰，模式清晰
②专业服务团队，拥有专业的技术经纪人
③严密的学校、企业审核机制，保证真实性
④拥有大量企业、投资机构、高校以及科研机构资源</div>
				<div class='cn_t'>我们的使命：
成为最顶尖的科技成果转化服务机构。
通过本网站的平台优势和服务，将中国高校、科研机构的科研成果产业化，为高校、科研机构的新技术新成果提供技术转化服务，并协助其与企业达成合作。为高校、科研机构的科研成果走向市场、为推动企业技术升级、为科技报国和产业报国、为科学技术提升人类的生活品质而孜孜以求。</div>
				<div class='cn_t'>我们的目标：
致力于打造科技服务第一平台。
成为推动人类品质生活的技术服务商。</div>
			</div>


			<div class='fl cn' id="divCallUs">
				<div class='cn_ti'>联系我们</div>
				<div class='ims'><%-- <img src='${pageContext.request.contextPath}/resources/images/front/img/ims.png' width="100%" /> --%></div>
				<div class='cn_t'>欢迎您通过电话或者邮件的形式与我们取得联系！</div>
				<div class='cn_t'>我们将为您提供最为优质的服务。</div>
				<div class='cn_t'>联系电话：010-57207996</div>
				<div class='cn_t'>QQ：2174530387</div>
				<div class='cn_t'>邮件：linkcc_service@yeah.net</div>
			</div>

			<div class='fl cn' id="divJoin">
				<div class='cn_ti'>信息发布</div>
				<div class='ims'><%-- <img src='${pageContext.request.contextPath}/resources/images/front/img/ims.png' width="100%" /> --%></div>
				<div class='cn_t'>您只需注册为我们的会员，方可免费发布项目或者需求，并获得我们提供的专业服务。</div>
				<div class='cn_t'>对于企业用户：
您填写好企业信息后，方可发布需求。需要注意的是，为了我们更好的为您提供服务，您只有维护好企业信息，并提交成功，才可以发布需求。
您可以发布如下两种需求：
若您本身有项目或者科研成果，需要寻求合作或者资金支持，您可以选择发布“资金需求”；
若您需要解决生产、转型中的技术难题，或者需要获取某行业最新的科研成果，您可以选择发布“技术需求”。
您可以浏览科研成果、科研团队、投资方等列表，并收藏自己感兴趣的项目或者投资方，以便日后查询，亦可直接发送合作意向。
与此同时，我们也会根据您所在行业领域，为您推荐优质的科研成果或者投资方。您可以在“我的推荐”中进行查看。</div>

				<div class='cn_t'>对于科研机构用户：
在注册时，您可以根据您的实际情况选择如下类型：
高校：各大院校。
科研机构：长期有组织地从事研究与开发活动的机构。
个人：具有研发能力的个人或者研发团队，但是未注册登记为企业或者机构用户。
您可以浏览企业技术需求、投资方等列表，并收藏自己感兴趣的需求或者投资方，以便日后查询，亦可直接发送合作意向。
与此同时，我们也会根据您所在行业领域，为您推荐优质的技术需求或者投资方。您可以在“我的推荐”中进行查看。</div>

				<div class='cn_t'>对于投资方用户：
您可以在“我的投资意向”中维护您的投资方信息，并维护相应的投资意向。维护成功后，我们将根据您的投资意向，为您推荐优质的项目。
您可以浏览科研成果、科研团队、企业资金需求等列表，并收藏自己感兴趣的项目，以便日后查询，亦可直接发送合作意向。

成为我们的会员，您会获得我们为您提供的“一对一”专业服务，技术经纪人会根据您的实际需求，为您推荐优质的项目或需求，并推动双方达成合作。</div>
			</div>
			<div class='fl cn' id="divExplian">
				<div class='cn_ti'>注册协议</div>
				<div class='ims'><%-- <img src='${pageContext.request.contextPath}/resources/images/front/img/ims.png' width="100%" /> --%></div>
				<div class='cn_t'>一、总则
1.1 联科网（linkcc.cn）的所有权和运营权归北京东正影视文化传播有限公司所有。 
1.2 用户在注册之前，应当仔细阅读本协议，并同意遵守本协议后方可成为注册用户。一旦注册成功，则用户与联科网（linkcc.cn）之间自动形成协议关系，用户应当受本协议的约束。用户在使用特殊的服务或产品时，应当同意接受相关协议后方能使用。 
1.3 本协议可由联科网（linkcc.cn）随时更新，用户应当及时关注并同意本站不承担通知义务。本站的通知、公告、声明或其它类似内容是本协议的一部分。</div>

				<div class='cn_t'>二、服务内容
2.1 联科网（linkcc.cn）的具体内容由本站根据实际情况提供。 
2.2 本站仅提供相关的网络服务，除此之外与相关网络服务有关的设备（如个人电脑、手机、及其他与接入互联网或移动网有关的装置）及所需的费用（如为接入互联网而支付的电话费及上网费、为使用移动网而支付的手机费）均应由用户自行负担。</div>

				<div class='cn_t'>三、用户账号
3.1 经本站注册系统完成注册程序并通过身份认证的用户即成为正式用户，可以获得本站规定用户所应享有的一切权限；未经认证仅享有本站规定的部分会员权限。联科网（linkcc.cn）有权对会员的权限设计进行变更。 
3.2 用户只能按照注册要求进行注册。用户有义务保证密码和账号的安全，用户利用该密码和账号所进行的一切活动引起的任何损失或损害，由用户自行承担全部责任，本站不承担任何责任。如用户发现账号遭到未授权的使用或发生其他任何安全问题，应立即修改账号密码并妥善保管，如有必要，请通知本站。因黑客行为或用户的保管疏忽导致账号非法使用，本站不承担任何责任。</div>
				<div class='cn_t'>四、使用规则
4.1 遵守中华人民共和国相关法律法规，包括但不限于《中华人民共和国计算机信息系统安全保护条例》、《计算机软件保护条例》、《最高人民法院关于审理涉及计算机网络著作权纠纷案件适用法律若干问题的解释（法释[2004]1号）》、《全国人大常委会关于维护互联网安全的决定》、《互联网电子公告服务管理规定》、《互联网新闻信息服务管理规定》、《互联网著作权行政保护办法》和《信息网络传播权保护条例》等有关计算机互联网规定和知识产权的法律和法规、实施办法。 
4.2 用户对其自行发表、上传或传送的内容负全部责任，所有用户不得在本站任何页面发布、转载、传送含有下列内容之一的信息，否则本站有权自行处理并不通知用户：
（1）违反宪法确定的基本原则的； 
（2）危害国家安全，泄漏国家机密，颠覆国家政权，破坏国家统一的； 
（3）损害国家荣誉和利益的； 
（4）煽动民族仇恨、民族歧视，破坏民族团结的； 
（5）破坏国家宗教政策，宣扬邪教和封建迷信的； 
（6）散布谣言，扰乱社会秩序，破坏社会稳定的；
（7）散布淫秽、色情、赌博、暴力、恐怖或者教唆犯罪的； 
（8）侮辱或者诽谤他人，侵害他人合法权益的； 
（9）煽动非法集会、结社、游行、示威、聚众扰乱社会秩序的； 
（10）以非法民间组织名义活动的；
（11）含有法律、行政法规禁止的其他内容的。
4.3 用户承诺对其发表或者上传于本站的所有信息（即属于《中华人民共和国著作权法》规定的作品，包括但不限于文字、图片、音乐、电影、表演和录音录像制品和电脑程序等）均享有完整的知识产权，或者已经得到相关权利人的合法授权；如用户违反本条规定造成本站被第三人索赔的，用户应全额补偿本站一切费用（包括但不限于各种赔偿费、诉讼代理费及为此支出的其它合理费用）； 
4.4 当第三方认为用户发表或者上传于本站的信息侵犯其权利，并根据《信息网络传播权保护条例》或者相关法律规定向本站发送权利通知书时，用户同意本站可以自行判断决定删除涉嫌侵权信息，除非用户提交书面证据材料排除侵权的可能性，本站将不会自动恢复上述删除的信息；
（1）不得为任何非法目的而使用网络服务系统； 
（2）遵守所有与网络服务有关的网络协议、规定和程序；
（3）不得利用本站进行任何可能对互联网的正常运转造成不利影响的行为； 
（4）不得利用本站进行任何不利于本站的行为。
4.5 如用户在使用网络服务时违反上述任何规定，本站有权要求用户改正或直接采取一切必要的措施（包括但不限于删除用户张贴的内容、暂停或终止用户使用网络服务的权利）以减轻用户不当行为而造成的影响。</div>
				<div class='cn_t'>五、隐私保护
5.1 本站不对外公开或向第三方提供单个用户的注册资料及用户在使用网络服务时存储在本站的非公开内容，但下列情况除外：
（1）事先获得用户的明确授权； 
（2）根据有关的法律法规要求；
（3）按照相关政府主管部门的要求；
（4）为维护社会公众的利益。
5.2 本站可能会与第三方合作向用户提供相关的网络服务，在此情况下，如该第三方同意承担与本站同等的保护用户隐私的责任，则本站有权将用户的注册资料等提供给该第三方。
5.3 在不透露单个用户隐私资料的前提下，本站有权对整个用户数据库进行分析并对用户数据库进行商业上的利用。</div>
				<div class='cn_t'>六、版权声明
6.1 本站的文字、图片、音频、视频等版权均归北京东正影视文化传播有限公司享有或与作者共同享有，未经本站许可，不得任意转载。 
6.2 本站特有的标识、版面设计、编排方式等版权均属北京东正影视文化传播有限公司享有，未经本站许可，不得任意复制或转载。 
6.3 使用本站的任何内容均应注明“来源于联科网（linkcc.cn）”及署上作者姓名，按法律规定需要支付稿酬的，应当通知本站及作者及支付稿酬，并独立承担一切法律责任。
6.4 本站享有所有作品用于其它用途的优先权，包括但不限于网站、电子杂志、平面出版等，但在使用前会通知作者，并按同行业的标准支付稿酬。
6.5 本站所有内容仅代表作者自己的立场和观点，与本站无关，由作者本人承担一切法律责任。 
6.6 恶意转载本站内容的，本站保留将其诉诸法律的权利。</div>
				<div class='cn_t'>七、责任声明
7.1 用户明确同意其使用本站网络服务所存在的风险及一切后果将完全由用户本人承担，联科网（linkcc.cn）对此不承担任何责任。 
7.2 本站无法保证网络服务一定能满足用户的要求，也不保证网络服务的及时性、安全性、准确性。 
7.3 本站不保证为方便用户而设置的外部链接的准确性和完整性，同时，对于该等外部链接指向的不由本站实际控制的任何网页上的内容，本站不承担任何责任。
7.4 对于因不可抗力或本站不能控制的原因造成的网络服务中断或其它缺陷，本站不承担任何责任，但将尽力减少因此而给用户造成的损失和影响。
7.5 对于站向用户提供的下列产品或者服务的质量缺陷本身及其引发的任何损失，本站无需承担任何责任：（1）本站向用户免费提供的各项网络服务； 
（2）本站向用户赠送的任何产品或者服务。
7.6 本站有权于任何时间暂时或永久修改或终止本服务（或其任何部分），而无论其通知与否，本站对用户和任何第三人均无需承担任何责任。</div>
				<div class='cn_t'>八、附则
8.1 本协议的订立、执行和解释及争议的解决均应适用中华人民共和国法律。 
8.2 如本协议中的任何条款无论因何种原因完全或部分无效或不具有执行力，本协议的其余条款仍应有效并且有约束力。
8.3 本协议解释权及修订权归北京东正影视文化传播有限公司所有。</div>
			</div>

			<div class='fl cn' id="divAgreement">
				<div class='cn_ti'>注册协议</div>
				<div class='ims'><%-- <img src='${pageContext.request.contextPath}/resources/images/front/img/ims.png' width="100%" /> --%></div>
				<div class='cn_t'>一、总则
1.1 联科网（linkcc.cn）的所有权和运营权归北京东正影视文化传播有限公司所有。 
1.2 用户在注册之前，应当仔细阅读本协议，并同意遵守本协议后方可成为注册用户。一旦注册成功，则用户与联科网（linkcc.cn）之间自动形成协议关系，用户应当受本协议的约束。用户在使用特殊的服务或产品时，应当同意接受相关协议后方能使用。 
1.3 本协议可由联科网（linkcc.cn）随时更新，用户应当及时关注并同意本站不承担通知义务。本站的通知、公告、声明或其它类似内容是本协议的一部分。</div>

				<div class='cn_t'>二、服务内容
2.1 联科网（linkcc.cn）的具体内容由本站根据实际情况提供。 
2.2 本站仅提供相关的网络服务，除此之外与相关网络服务有关的设备（如个人电脑、手机、及其他与接入互联网或移动网有关的装置）及所需的费用（如为接入互联网而支付的电话费及上网费、为使用移动网而支付的手机费）均应由用户自行负担。</div>

				<div class='cn_t'>三、用户账号
3.1 经本站注册系统完成注册程序并通过身份认证的用户即成为正式用户，可以获得本站规定用户所应享有的一切权限；未经认证仅享有本站规定的部分会员权限。联科网（linkcc.cn）有权对会员的权限设计进行变更。 
3.2 用户只能按照注册要求进行注册。用户有义务保证密码和账号的安全，用户利用该密码和账号所进行的一切活动引起的任何损失或损害，由用户自行承担全部责任，本站不承担任何责任。如用户发现账号遭到未授权的使用或发生其他任何安全问题，应立即修改账号密码并妥善保管，如有必要，请通知本站。因黑客行为或用户的保管疏忽导致账号非法使用，本站不承担任何责任。</div>
				<div class='cn_t'>四、使用规则
4.1 遵守中华人民共和国相关法律法规，包括但不限于《中华人民共和国计算机信息系统安全保护条例》、《计算机软件保护条例》、《最高人民法院关于审理涉及计算机网络著作权纠纷案件适用法律若干问题的解释（法释[2004]1号）》、《全国人大常委会关于维护互联网安全的决定》、《互联网电子公告服务管理规定》、《互联网新闻信息服务管理规定》、《互联网著作权行政保护办法》和《信息网络传播权保护条例》等有关计算机互联网规定和知识产权的法律和法规、实施办法。 
4.2 用户对其自行发表、上传或传送的内容负全部责任，所有用户不得在本站任何页面发布、转载、传送含有下列内容之一的信息，否则本站有权自行处理并不通知用户：
（1）违反宪法确定的基本原则的； 
（2）危害国家安全，泄漏国家机密，颠覆国家政权，破坏国家统一的； 
（3）损害国家荣誉和利益的； 
（4）煽动民族仇恨、民族歧视，破坏民族团结的； 
（5）破坏国家宗教政策，宣扬邪教和封建迷信的； 
（6）散布谣言，扰乱社会秩序，破坏社会稳定的；
（7）散布淫秽、色情、赌博、暴力、恐怖或者教唆犯罪的； 
（8）侮辱或者诽谤他人，侵害他人合法权益的； 
（9）煽动非法集会、结社、游行、示威、聚众扰乱社会秩序的； 
（10）以非法民间组织名义活动的；
（11）含有法律、行政法规禁止的其他内容的。
4.3 用户承诺对其发表或者上传于本站的所有信息（即属于《中华人民共和国著作权法》规定的作品，包括但不限于文字、图片、音乐、电影、表演和录音录像制品和电脑程序等）均享有完整的知识产权，或者已经得到相关权利人的合法授权；如用户违反本条规定造成本站被第三人索赔的，用户应全额补偿本站一切费用（包括但不限于各种赔偿费、诉讼代理费及为此支出的其它合理费用）； 
4.4 当第三方认为用户发表或者上传于本站的信息侵犯其权利，并根据《信息网络传播权保护条例》或者相关法律规定向本站发送权利通知书时，用户同意本站可以自行判断决定删除涉嫌侵权信息，除非用户提交书面证据材料排除侵权的可能性，本站将不会自动恢复上述删除的信息；
（1）不得为任何非法目的而使用网络服务系统； 
（2）遵守所有与网络服务有关的网络协议、规定和程序；
（3）不得利用本站进行任何可能对互联网的正常运转造成不利影响的行为； 
（4）不得利用本站进行任何不利于本站的行为。
4.5 如用户在使用网络服务时违反上述任何规定，本站有权要求用户改正或直接采取一切必要的措施（包括但不限于删除用户张贴的内容、暂停或终止用户使用网络服务的权利）以减轻用户不当行为而造成的影响。</div>
				<div class='cn_t'>五、隐私保护
5.1 本站不对外公开或向第三方提供单个用户的注册资料及用户在使用网络服务时存储在本站的非公开内容，但下列情况除外：
（1）事先获得用户的明确授权； 
（2）根据有关的法律法规要求；
（3）按照相关政府主管部门的要求；
（4）为维护社会公众的利益。
5.2 本站可能会与第三方合作向用户提供相关的网络服务，在此情况下，如该第三方同意承担与本站同等的保护用户隐私的责任，则本站有权将用户的注册资料等提供给该第三方。
5.3 在不透露单个用户隐私资料的前提下，本站有权对整个用户数据库进行分析并对用户数据库进行商业上的利用。</div>
				<div class='cn_t'>六、版权声明
6.1 本站的文字、图片、音频、视频等版权均归北京东正影视文化传播有限公司享有或与作者共同享有，未经本站许可，不得任意转载。 
6.2 本站特有的标识、版面设计、编排方式等版权均属北京东正影视文化传播有限公司享有，未经本站许可，不得任意复制或转载。 
6.3 使用本站的任何内容均应注明“来源于联科网（linkcc.cn）”及署上作者姓名，按法律规定需要支付稿酬的，应当通知本站及作者及支付稿酬，并独立承担一切法律责任。
6.4 本站享有所有作品用于其它用途的优先权，包括但不限于网站、电子杂志、平面出版等，但在使用前会通知作者，并按同行业的标准支付稿酬。
6.5 本站所有内容仅代表作者自己的立场和观点，与本站无关，由作者本人承担一切法律责任。 
6.6 恶意转载本站内容的，本站保留将其诉诸法律的权利。</div>
				<div class='cn_t'>七、责任声明
7.1 用户明确同意其使用本站网络服务所存在的风险及一切后果将完全由用户本人承担，联科网（linkcc.cn）对此不承担任何责任。 
7.2 本站无法保证网络服务一定能满足用户的要求，也不保证网络服务的及时性、安全性、准确性。 
7.3 本站不保证为方便用户而设置的外部链接的准确性和完整性，同时，对于该等外部链接指向的不由本站实际控制的任何网页上的内容，本站不承担任何责任。
7.4 对于因不可抗力或本站不能控制的原因造成的网络服务中断或其它缺陷，本站不承担任何责任，但将尽力减少因此而给用户造成的损失和影响。
7.5 对于站向用户提供的下列产品或者服务的质量缺陷本身及其引发的任何损失，本站无需承担任何责任：（1）本站向用户免费提供的各项网络服务； 
（2）本站向用户赠送的任何产品或者服务。
7.6 本站有权于任何时间暂时或永久修改或终止本服务（或其任何部分），而无论其通知与否，本站对用户和任何第三人均无需承担任何责任。</div>
				<div class='cn_t'>八、附则
8.1 本协议的订立、执行和解释及争议的解决均应适用中华人民共和国法律。 
8.2 如本协议中的任何条款无论因何种原因完全或部分无效或不具有执行力，本协议的其余条款仍应有效并且有约束力。
8.3 本协议解释权及修订权归北京东正影视文化传播有限公司所有。</div>
			</div>
			</div>
			<div class='clear'></div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/authority/aboutus.js"></script>
</body>
<script type="text/javascript">
	$(function(){
		$('.cons .right .xuqiu4 .input').click(function(){
			if($(this).hasClass('on')){
				$(this).removeClass("on");
				$(this).find("dl").slideUp(100);
			}else{
				$(this).addClass("on");
				$(this).find("dl").slideDown(100);
			}
		});
		$('.cons .right .xuqiu4 .input dd').click(function(){
			$(this).parents(".input").find("input").val($(this).text());
		})

		$(".headbg .input .button").click(function(){
			if($(this).hasClass('on')){
				$(this).removeClass("on");
				$(".headbg .input .button dl").slideUp(100);
			}else{
				$(this).addClass("on");
				$(".headbg .input .button dl").slideDown(100);
			}
		})

		$('.headbg .input .button dd').click(function(){
			$(this).parents(".button").find("span").text($(this).text());
		})

		$(".listd .heads .list .checkbox").click(function(){
			if($(this).hasClass('on')){
				$(this).removeClass("on");
				$(this).find('img').attr("src",'${pageContext.request.contextPath}/resources/images/front/img/checkbox.png')
			}else{
				$(this).addClass("on");
				$(this).find('img').attr("src",'${pageContext.request.contextPath}/resources/images/front/img/checkbox2.png')
			}

		})


	})
</script>
</html>
