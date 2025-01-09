package com.vbms.rpc;

import hibernateconfig.hbm.VbmsScheme;

import java.util.List;

import com.vbms.domain.VbmsComplaintDTO;
import com.vbms.domain.VbmsSchemeDTO;
import com.vbms.domain.VbmsUserDTO;
import com.vbms.domain.VbmsVoterDTO;
import com.vbms.exception.VBMSException;
import com.vbms.service.Interface.IService;

public class VBMSRpcService {
	private IService iserviceObj;

	public IService getIserviceObj() {
 		return iserviceObj;
		 
	}

	public void setIserviceObj(IService iserviceObj) {
		this.iserviceObj = iserviceObj;
	}
/** Login Valiation**/
	public VbmsUserDTO validateLogin(VbmsUserDTO userDTOObj) throws VBMSException {
		return getIserviceObj().findUser(userDTOObj);
	}
	public List<String> getUserTabs(VbmsUserDTO userDTOObj) throws VBMSException{
		return getIserviceObj().getUserTabs(userDTOObj);
	}

	/* The below method is to provide the menu string */
	/*
	 * public VbmsUserDTO getMenuString(VbmsUserDTO userDTOObj) throws
	 * VBMSException{
	 * 
	 * }
	 */

	/*
	 * *****************************************Users****************************
	 * *******************
	 */

	/* The below methhod is to provide the list of users */
	public List<VbmsUserDTO> fetchUser(VbmsUserDTO userDTOObj)
			throws VBMSException {
		return getIserviceObj().fetchUser(userDTOObj);
	}
	/* The Method saves the user */
	
	  public List<VbmsUserDTO> saveorUpdateUser(List<VbmsUserDTO>
	  userDTOList)throws VBMSException{
	 return getIserviceObj().saveorUpdateUser(userDTOList);
	  }
	 

	/*
	 * ******************************************voters**************************
	 * *********************
	 */

	/* The below methhod is to provide the list of voters */
	
	  public List<VbmsVoterDTO> fetchVoter(VbmsVoterDTO voterDTOObj)throws
	  VBMSException{
		  return getIserviceObj().fetchVoter(voterDTOObj);
	  }
	 /* The Method saves the voters */
	
	 public List<VbmsVoterDTO> saveorUpdateVoter(List<VbmsVoterDTO>
	  voterDTOList)throws VBMSException{
		 return getIserviceObj().saveorUpdateVoter(voterDTOList);
	  }
	 /**
	 
	 * *******************************************Schemes*********************
	 * ************************
	 */

	
	  public List<VbmsSchemeDTO> fetchSchemes(VbmsSchemeDTO schemeDTOObj)throws
	  VBMSException{
			return getIserviceObj().fetchSchemes(schemeDTOObj);
	  }
	 // The Method saves the voters 
	
	  public List<VbmsSchemeDTO> saveorUpdateScheme(List<VbmsSchemeDTO>
	  schemeDTOList)throws VBMSException{
			return getIserviceObj().saveorUpdateScheme(schemeDTOList);
	  }
	 
	  
	  /**
		 
		 * *******************************************Complaints*********************
		 * ************************
		 */

		
		  public List<VbmsComplaintDTO> fetchComplaints(VbmsComplaintDTO complaintsDTOObj)throws
		  VBMSException{
				return getIserviceObj().fetchComplaints(complaintsDTOObj);
		  }
		 // The Method saves the voters 
		
		  public List<VbmsComplaintDTO> saveorUpdateComlaints(List<VbmsComplaintDTO>
		  complaintsDTOList)throws VBMSException{
				return getIserviceObj().saveorUpdateComlaints(complaintsDTOList);
		  }
		
		  public List<VbmsComplaintDTO> fetchComplaintsReport(VbmsComplaintDTO complaintsDTOObj)throws
		  VBMSException{
				return getIserviceObj().fetchComplaintsReport(complaintsDTOObj);
		  }
		
		  
}
