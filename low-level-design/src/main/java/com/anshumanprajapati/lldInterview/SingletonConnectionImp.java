package lldInterview;

public class SingletonConnectionImp {
	
	
	static volatile ConnectionObj connectionObj = null;
	
	ConnectionObj createConnection(){
		
		if(connectionObj == null){	
			synchronized (SingletonConnectionImp.class) {
				if(connectionObj == null) {
					connectionObj =  new ConnectionObj();
					return  connectionObj;
					
				}
				
			}
					
			
		}
		
		return connectionObj;
		
	}
}
