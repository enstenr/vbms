package com.vbms.dao.Interface;

import hibernateconfig.hbm.VbmsComplaint;
import hibernateconfig.hbm.VbmsMenu;
import hibernateconfig.hbm.VbmsScheme;
import hibernateconfig.hbm.VbmsUser;
import hibernateconfig.hbm.VbmsVoter;

import java.util.List;

import com.vbms.domain.VbmsComplaintDTO;
import com.vbms.domain.VbmsSchemeDTO;
import com.vbms.domain.VbmsUserDTO;
import com.vbms.domain.VbmsVoterDTO;
import com.vbms.exception.VBMSException;

public interface IDao {
 public List<VbmsUser>  fetchUser(VbmsUserDTO userDTOObj) throws VBMSException;
 public  VbmsUser findUser(VbmsUserDTO userDTOObj) throws VBMSException;
 public List<VbmsMenu> getAllMenu() throws VBMSException;
public List<VbmsUserDTO> saveorUpdateUser(List<VbmsUserDTO> userDTOList)throws VBMSException;
public List<VbmsScheme> fetchSchemes(VbmsSchemeDTO schemeDTOObj) throws VBMSException;
public List<VbmsSchemeDTO> saveorUpdateScheme(List<VbmsSchemeDTO> schemeDTOList) throws VBMSException;
public List<VbmsVoter> fetchVoter(VbmsVoterDTO voterDTOObj)throws VBMSException;
public List<VbmsVoter> saveorUpdateVoter(List<VbmsVoterDTO> voterDTOList)throws VBMSException;
public List<VbmsComplaint> fetchComplaints(VbmsComplaintDTO complaintsDTOObj)throws VBMSException;
public List<VbmsComplaint> saveorUpdateComlaints(List<VbmsComplaintDTO> complaintsDTOList)throws VBMSException;
public List<VbmsComplaint> fetchComplaintsReport(VbmsComplaintDTO complaintsDTOObj)throws VBMSException;
 }