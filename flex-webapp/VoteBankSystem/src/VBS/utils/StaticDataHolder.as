 
package VBS.utils
{
	import mx.collections.ArrayCollection;
	
	public class StaticDataHolder
	{
		private static var userId:String;
		private static var sessionId:String;
		private static var userName:String;
		private static var clientIp:String;
		private static var menuString:String;
		private static var userType:String;
	  	/**
		 * @return the userId
		 */
		public static function getSessionId():String {
			return sessionId;
		}
		
		/**
		 * @param userId the userId to set
		 */
		public static function setSessionId(sessionId:String):void{
			StaticDataHolder.sessionId = sessionId;
		} 
		
		/**
		 * @return the userId
		 */
		public static function getUserId():String {
			return userId;
		}
		
		/**
		 * @param userId the userId to set
		 */
		public static function setUserId(userId:String):void{
			StaticDataHolder.userId = userId;
		} 
		
		/**
		 * @return the userName
		 */
		public static function getUserName():String {
			return userName;
		}
		
		/**
		 * @param userName the userName to set
		 */
		 public static function setUserName(userName:String):void{
			StaticDataHolder.userName = userName;
		} 
		
		
		
		/**
		 * @return the clientIp
		 */
		public static function getClientIp():String {
			return clientIp;
		}
		
		/**
		 * @param userLoginProfile the userLoginProfile to set
		 */
		public static function setClientIp(clientIp:String):void{
			StaticDataHolder.clientIp = clientIp;
		}
		
		
		/**
		 * @return the menuString
		 */
		public static function getMenuString():String {
			return menuString;
		}
		
		/**
		 * @param menuString the menuString to set
		 */
		public static function setMenuString(menuString:String):void{
			StaticDataHolder.menuString = menuString;
		}
		
	 
		
		public static function getUserType():String {
			return userType;
		}
		
		public static function setUserType(userType:String):void{
			StaticDataHolder.userType = userType;
		} 
		
	 
		
		 
		 
				
	}
}
