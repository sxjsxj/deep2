
/**
 * 获取查询的默认值
 * @param subType 
 * 1 -- 公众查询，仅查询审核通过的。
 * 2 -- 自己查询，查询所有状态的。
 * 3 -- 我的推荐，推荐标识为推荐，状态都是审核通过的。
 * 4 -- 我的收藏/关注，查询审核通过的。。。
 * @param queryParam
 */
function getDefaultQuery(type, subType, queryParam) {
	if(type == 'user'){
		if(subType == '1') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			queryParam['status'] = '0,1,2';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		} else if(subType == '4') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		}
	}
	if(type == 'researchGroup'){
		if(subType == '1') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			queryParam['status'] = '0,1,2';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
			//queryParam['recommendFlag'] = '1';
		} else if(subType == '4') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		}
	} 
	if(type == 'achievement'){
		if(subType == '1') {
			queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			queryParam['status'] = '0,1,2,3,4,5';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			queryParam['status'] = '1,2';
			queryParam['removeFlag'] = '0';
			//queryParam['recommendFlag'] = '1';
		} else if(subType == '4') {
			queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		}
	} 
	if(type == 'researchGroupFollower'){
		if(subType == '1') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			//queryParam['status'] = '0,1,2,3,4,5';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '4') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
			queryParam['researchGroupFollowerIdQueryModel']=getFollowerId('1');
		}
	} 
	if(type == 'achievementFollower'){
		if(subType == '1') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			//queryParam['status'] = '0,1,2,3,4,5';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '4') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
			queryParam['achievementFollowerIdQueryModel']=getFollowerId('1');
		}
	} 
	if(type == 'companyUser'){
		if(subType == '1') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			queryParam['status'] = '0,1,2';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		} else if(subType == '4') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		}
	} 
	if(type == 'techRequirement'){
		if(subType == '1') {
			queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			queryParam['status'] = '0,1,2,3,4,5';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			queryParam['status'] = '1,2';
			queryParam['removeFlag'] = '0';
			//queryParam['recommendFlag'] = '1';
		} else if(subType == '4') {
			queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		}
	} 
	if(type == 'fundRequirement'){
		if(subType == '1') {
			queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			queryParam['status'] = '0,1,2,3,4,5';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			queryParam['status'] = '1,2';
			queryParam['removeFlag'] = '0';
			//queryParam['recommendFlag'] = '1';
		} else if(subType == '4') {
			queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		}
	} 
	if(type == 'techRequirementFollower'){
		if(subType == '1') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			//queryParam['status'] = '0,1,2,3,4,5';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '4') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
			queryParam['techRequirementFollowerIdQueryModel']=getFollowerId('1');
		}
	} 
	if(type == 'fundRequirementFollower'){
		if(subType == '1') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			//queryParam['status'] = '0,1,2,3,4,5';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '4') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
			queryParam['fundRequirementFollowerIdQueryModel']=getFollowerId('1');
		}
	} 
	if(type == 'investorUser'){
		if(subType == '1') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			queryParam['status'] = '0,1,2';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
			//queryParam['recommendFlag'] = '1';
		} else if(subType == '4') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		}
	} 
	if(type == 'investorUserFollower'){
		if(subType == '1') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			//queryParam['status'] = '0,1,2,3,4,5';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '4') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
			queryParam['investorUserFollowerIdQueryModel']=getFollowerId('1');
		}
	} 
};

function getMyInfo() {
	var currentUserId = $("#commonUserLoginId").val();
	var userQueryModel = {};
	userQueryModel['id']=currentUserId;
	return userQueryModel;
};

/**
 * @param type
 * 0：关注
 * 1：收藏
 * @returns 
 */
function getFollowerId(type) {
	var idQueryModel = {};
	idQueryModel['userId']=$("#commonUserLoginId").val();
    if(type == '0') {
    	idQueryModel['relationType']='0';
    }
    if(type == '1') {
    	idQueryModel['relationType']='1';
    }
    return idQueryModel;
};