package hibernateconfig.hbm;
// Generated Jan 23, 2012 6:57:48 AM by Hibernate Tools 3.4.0.CR1



/**
 * VbmsMenu generated by hbm2java
 */
public class VbmsMenu  implements java.io.Serializable {


     private int menuId;
     private String menuLevel;
     private String componentName;

    public VbmsMenu() {
    }

	
    public VbmsMenu(int menuId) {
        this.menuId = menuId;
    }
    public VbmsMenu(int menuId, String menuLevel, String componentName) {
       this.menuId = menuId;
       this.menuLevel = menuLevel;
       this.componentName = componentName;
    }
   
    public int getMenuId() {
        return this.menuId;
    }
    
    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }
    public String getMenuLevel() {
        return this.menuLevel;
    }
    
    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }
    public String getComponentName() {
        return this.componentName;
    }
    
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }




}


