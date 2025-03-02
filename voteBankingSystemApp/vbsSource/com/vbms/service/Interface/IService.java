package com.vbms.service.Interface;

import hibernateconfig.hbm.VbmsScheme;

import java.util.List;

import com.vbms.domain.VbmsComplaintDTO;
import com.vbms.domain.VbmsSchemeDTO;
import com.vbms.domain.VbmsUserDTO;
import com.vbms.domain.VbmsVoterDTO;
import com.vbms.exception.VBMSException;

public interface IService {
	public List<VbmsUserDTO> fetchUser(VbmsUserDTO userDTOObj)throws VBMSException;
	public  VbmsUserDTO findUser(VbmsUserDTO userDTOObj) throws VBMSException;
	public List<String> getUserTabs(VbmsUserDTO userDTOObj) throws VBMSException;
	public List<VbmsUserDTO> saveorUpdateUser(List<VbmsUserDTO> userDTOList) throws VBMSException;
	public List<VbmsSchemeDTO> fetchSchemes(VbmsSchemeDTO schemeDTOObj)throws VBMSException;
	public List<VbmsSchemeDTO> saveorUpdateScheme(List<VbmsSchemeDTO> schemeDTOList)throws VBMSException;
	public List<VbmsVoterDTO> fetchVoter(VbmsVoterDTO voterDTOObj)throws VBMSException;
	public List<VbmsVoterDTO> saveorUpdateVoter(List<VbmsVoterDTO> voterDTOList)throws VBMSException;
	public List<VbmsComplaintDTO> fetchComplaints(VbmsComplaintDTO complaintsDTOObj)throws VBMSException;
	public List<VbmsComplaintDTO> saveorUpdateComlaints(List<VbmsComplaintDTO> complaintsDTOList)throws VBMSException;
	public List<VbmsComplaintDTO> fetchComplaintsReport(VbmsComplaintDTO complaintsDTOObj)throws VBMSException;
 }
