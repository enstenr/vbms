package com.vbms.dao;

 

import hibernateconfig.hbm.VbmsComplaint;
import hibernateconfig.hbm.VbmsMenu;
import hibernateconfig.hbm.VbmsScheme;
import hibernateconfig.hbm.VbmsUser;
import hibernateconfig.hbm.VbmsVoter;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.vbms.dao.Interface.IDao;
import com.vbms.domain.VbmsComplaintDTO;
import com.vbms.domain.VbmsSchemeDTO;
import com.vbms.domain.VbmsUserDTO;
import com.vbms.domain.VbmsVoterDTO;
import com.vbms.exception.VBMSException;
import com.vbms.util.VBMSUtil;

public class DaoImpl   extends HibernateDaoSupport implements IDao {
	private HibernateTemplate template;

 
 	
 	
 	public  VbmsUser findUser(VbmsUserDTO userDTOObj) throws VBMSException {
 		DetachedCriteria detachedObj=DetachedCriteria.forClass(VbmsUser.class).add(Restrictions.eq("userLogin", userDTOObj.getUserLogin()));
 		List<VbmsUser> userResultObj=(List<VbmsUser>)getHibernateTemplate().findByCriteria(detachedObj);
 		if(userResultObj==null || userResultObj.size()==0)
 			throw new VBMSException("User Not Found. Please contact Administrator ");
 		if(userResultObj.size()>1)
 			throw new VBMSException("More than One User Found. Please contact Administrator ");
 		return ( userResultObj.get(0));	
 		}

	public List<VbmsMenu> getAllMenu() throws VBMSException {
	return (List<VbmsMenu>)getHibernateTemplate().loadAll(VbmsMenu.class);
		 
	}

	public List<VbmsUserDTO> saveorUpdateUser(List<VbmsUserDTO> userDTOList)
			throws VBMSException {
		  try {
			getHibernateTemplate().saveOrUpdateAll(VBMSUtil.convertUserDTOListToDomain(userDTOList));
		} catch (DataAccessException e) {
			 throw new VBMSException(e.getMessage());
		}
		  return userDTOList;
	}
	public List<VbmsUser> fetchUser(VbmsUserDTO userDTOObj) {
		return (List<VbmsUser>)getHibernateTemplate().loadAll(VbmsUser.class);	
		}

	public List<VbmsScheme> fetchSchemes(VbmsScheme schemeDTOObj)
			throws VBMSException {
		return (List<VbmsScheme>)getHibernateTemplate().loadAll(VbmsScheme.class);
		
	}

	public List<VbmsSchemeDTO> saveorUpdateScheme(List<VbmsSchemeDTO> schemeDTOList)
			throws VBMSException {
	 	  	getHibernateTemplate().saveOrUpdateAll(VBMSUtil.convertSchemeDTOListToDomain(schemeDTOList));
		  	return schemeDTOList;
	}

	public List<VbmsScheme> fetchSchemes(VbmsSchemeDTO schemeDTOObj)
			throws VBMSException {
		return (List<VbmsScheme>)getHibernateTemplate().loadAll(VbmsScheme.class);	
	}

	public List<VbmsVoter> fetchVoter(VbmsVoterDTO voterDTOObj)
			throws VBMSException {
		DetachedCriteria detachedObj=DetachedCriteria.forClass(VbmsVoter.class).
				add(Restrictions.and(
						Restrictions.ilike("votername", voterDTOObj.getVotername(),MatchMode.ANYWHERE),
						Restrictions.ilike("cardnumber", voterDTOObj.getCardnumber(),MatchMode.ANYWHERE)
						));
 		
		List<VbmsVoter> voterResultObj=(List<VbmsVoter>)getHibernateTemplate().findByCriteria(detachedObj);
 	/*	if(voterResultObj==null || voterResultObj.size()==0)
 			throw new VBMSException("Voter Not Found. Please contact Administrator ");
 	*/	 
 		return voterResultObj;	
	}

	public List<VbmsVoter> saveorUpdateVoter(List<VbmsVoterDTO> voterDTOList) {
		List<VbmsVoter> vbmsVoterList=VBMSUtil.convertVoterDTOListToDomain(voterDTOList);
		getHibernateTemplate().saveOrUpdateAll((vbmsVoterList));
	  	return vbmsVoterList;
	}

	public List<VbmsComplaint> fetchComplaints(VbmsComplaintDTO complaintsDTOObj)
			throws VBMSException {
		return (List<VbmsComplaint>)getHibernateTemplate().loadAll(VbmsComplaint.class);	
	}

	public List<VbmsComplaint> saveorUpdateComlaints(
			List<VbmsComplaintDTO> complaintsDTOList) throws VBMSException {
		List<VbmsComplaint> vbmsVoterList=VBMSUtil.convertComplaintDTOListToDomain(complaintsDTOList);
		getHibernateTemplate().saveOrUpdateAll((vbmsVoterList));
	  	return vbmsVoterList;
	}

	public List<VbmsComplaint> fetchComplaintsReport(
			VbmsComplaintDTO complaintsDTOObj) throws VBMSException {
		 DetachedCriteria detachedCrtObj=DetachedCriteria.forClass(VbmsComplaint.class);
		 detachedCrtObj.add(Restrictions.eq("status", complaintsDTOObj.getStatus()));
		 
		 detachedCrtObj.add(Restrictions.between("updated_dttm",complaintsDTOObj.getFromDate(), complaintsDTOObj.getToDate()));
		 
		 return getHibernateTemplate().findByCriteria(detachedCrtObj);
		 
	}

	 

	 

 }
