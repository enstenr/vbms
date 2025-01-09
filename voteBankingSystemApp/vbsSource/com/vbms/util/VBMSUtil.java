package com.vbms.util;

 import hibernateconfig.hbm.VbmsComplaint;
import hibernateconfig.hbm.VbmsScheme;
import hibernateconfig.hbm.VbmsUser;
import hibernateconfig.hbm.VbmsVoter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.vbms.domain.VbmsComplaintDTO;
import com.vbms.domain.VbmsSchemeDTO;
import com.vbms.domain.VbmsUserDTO;
import com.vbms.domain.VbmsVoterDTO;

public class VBMSUtil {

	public static List<VbmsUserDTO> convertUserDomainListToDTO(List<VbmsUser> vbmsUserList){
		List<VbmsUserDTO> userDTOList=new ArrayList<VbmsUserDTO>();
		for(VbmsUser vbmsUserObj:vbmsUserList){
			userDTOList.add(convertvbmsUserDomaintoDTO(vbmsUserObj));
		}
		return userDTOList;
	}
	public static VbmsUserDTO convertvbmsUserDomaintoDTO(VbmsUser vmbsUserObj){
		VbmsUserDTO vbmsUserDTOObj=new VbmsUserDTO();
		BeanUtils.copyProperties(vmbsUserObj, vbmsUserDTOObj);
		return vbmsUserDTOObj;
	}
	
	
	public static List<VbmsUser> convertUserDTOListToDomain(List<VbmsUserDTO> vbmsUserList){
		List<VbmsUser> userDomainList=new ArrayList<VbmsUser>();
		for(VbmsUserDTO vbmsUserObj:vbmsUserList){
			userDomainList.add(convertvbmsUserDTOToDomain(vbmsUserObj));
		}
		return userDomainList;
	}
	public static VbmsUser convertvbmsUserDTOToDomain(VbmsUserDTO vmbsUserObj){
		VbmsUser vbmsUserDTOObj=new VbmsUser();
		BeanUtils.copyProperties(vmbsUserObj, vbmsUserDTOObj);
		return vbmsUserDTOObj;
	}
	
	/**
	 * For scheme
	 * @param vbmsUserList
	 * @return
	 */
	
	
	public static List<VbmsSchemeDTO> convertSchemeDomainListToDTO(List<VbmsScheme> vbmsUserList){
		List<VbmsSchemeDTO> userDTOList=new ArrayList<VbmsSchemeDTO>();
		for(VbmsScheme vbmsUserObj:vbmsUserList){
			userDTOList.add(convertvbmsSchemeDomaintoDTO(vbmsUserObj));
		}
		return userDTOList;
	}
	public static VbmsSchemeDTO convertvbmsSchemeDomaintoDTO(VbmsScheme vmbsUserObj){
		VbmsSchemeDTO vbmsUserDTOObj=new VbmsSchemeDTO();
		BeanUtils.copyProperties(vmbsUserObj, vbmsUserDTOObj);
		return vbmsUserDTOObj;
	}
	
	
	public static List<VbmsScheme> convertSchemeDTOListToDomain(List<VbmsSchemeDTO> vbmsUserList){
		List<VbmsScheme> userDomainList=new ArrayList<VbmsScheme>();
		for(VbmsSchemeDTO vbmsUserObj:vbmsUserList){
			userDomainList.add(convertSchemeDTOToDomain(vbmsUserObj));
		}
		return userDomainList;
	}
	public static VbmsScheme convertSchemeDTOToDomain(VbmsSchemeDTO vmbsUserObj){
		VbmsScheme vbmsUserDTOObj=new VbmsScheme();
		BeanUtils.copyProperties(vmbsUserObj, vbmsUserDTOObj);
		return vbmsUserDTOObj;
	}
	
	/** voter related method**/
	public static List<VbmsVoterDTO> convertVoterDomainListToDTO(
			List<VbmsVoter> vbmsVoterList) {
		List<VbmsVoterDTO> vbmsDTOList=new ArrayList<VbmsVoterDTO>();
		for(VbmsVoter vbmsVoterObj:vbmsVoterList){
			vbmsDTOList.add(convertvbmsVoterDomaintoDTO(vbmsVoterObj));
		}
		return vbmsDTOList;
	}
	private static VbmsVoterDTO convertvbmsVoterDomaintoDTO(
			VbmsVoter vbmsVoterObj) {
		VbmsVoterDTO vbmsUserDTOObj=new VbmsVoterDTO();
		BeanUtils.copyProperties(vbmsVoterObj, vbmsUserDTOObj);
		return vbmsUserDTOObj;
	}
	
	
	
	public static List<VbmsVoter> convertVoterDTOListToDomain(List<VbmsVoterDTO> vbmsUserList){
		List<VbmsVoter> userDomainList=new ArrayList<VbmsVoter>();
		for(VbmsVoterDTO vbmsVoterObj:vbmsUserList){
			userDomainList.add(convertVoterDTOToDomain(vbmsVoterObj));
		}
		return userDomainList;
	}
	public static VbmsVoter convertVoterDTOToDomain(VbmsVoterDTO vmbsUserObj){
		VbmsVoter vbmsVoterDTOObj=new VbmsVoter();
		BeanUtils.copyProperties(vmbsUserObj, vbmsVoterDTOObj);
		return vbmsVoterDTOObj;
	}
	
	
	
	public static List<VbmsComplaintDTO> convertComplaintDomainListToDTO(
			List<VbmsComplaint> vbmsVoterList) {
		List<VbmsComplaintDTO> vbmsDTOList=new ArrayList<VbmsComplaintDTO>();
		for(VbmsComplaint vbmsComplaintObj:vbmsVoterList){
			vbmsDTOList.add(convertvbmsComplaintDomaintoDTO(vbmsComplaintObj));
		}
		return vbmsDTOList;
	}
	private static VbmsComplaintDTO convertvbmsComplaintDomaintoDTO(
			VbmsComplaint vbmsComplaintObj) {
		VbmsComplaintDTO vbmsComplaintDTOObj=new VbmsComplaintDTO();
		BeanUtils.copyProperties(vbmsComplaintObj, vbmsComplaintDTOObj);
		return vbmsComplaintDTOObj;
	}
	
	
	
	public static List<VbmsComplaint> convertComplaintDTOListToDomain(List<VbmsComplaintDTO> vbmsUserList){
		List<VbmsComplaint> userDomainList=new ArrayList<VbmsComplaint>();
		for(VbmsComplaintDTO vbmsVoterObj:vbmsUserList){
			userDomainList.add(convertComplaintDTOToDomain(vbmsVoterObj));
		}
		return userDomainList;
	}
	public static VbmsComplaint convertComplaintDTOToDomain(VbmsComplaintDTO vmbsUserObj){
		VbmsComplaint vbmsVoterDTOObj=new VbmsComplaint();
		BeanUtils.copyProperties(vmbsUserObj, vbmsVoterDTOObj);
		return vbmsVoterDTOObj;
	}
	
	
}
