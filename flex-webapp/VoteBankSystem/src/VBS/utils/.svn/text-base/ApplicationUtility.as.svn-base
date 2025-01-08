 package VBS.utils 
{
	import flash.net.URLRequest;
	import flash.net.navigateToURL;
	
		
	public class ApplicationUtility
	{
		
		/**
		 * @private
		 * Method to signoff Application by redirecting to Logout.jsp
		 */
		public static function signOffApplication():void
		{
			try
			{
				var _url:String = "Logout.html";
				var _urlReq:URLRequest = new URLRequest(_url);
				navigateToURL(_urlReq,"_self");
			}
			catch(err:Error) { ; }
		}
		
		/**
		 * @private
		 * Method to to redirect to signin page on invalid login attempt
		 */
		public static function redirectIndexPage():void
		{
			try
			{
				var _url:String = "index.html";
				var _urlReq:URLRequest = new URLRequest(_url);
				navigateToURL(_urlReq,"_self");
			}
			catch(err:Error) { ; }
		}
		
		/**
		 * @private
		 * Method closes the application browser window.
		 */
		public static function closeApplicationWindow():void
		{
			try
			{
				var _url:String = "javascript:window.opener = self;window.close();"; 
			   	var _urlReq:URLRequest = new URLRequest(_url); 
			    navigateToURL(_urlReq,"_self"); 
			}
			catch(err:Error) { ; }
		}
	}
}