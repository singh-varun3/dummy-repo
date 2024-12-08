package Business.DB4OUtil;

import Business.ConfigureABusiness;
import Business.Business;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;

/**
 *
 * @author raunak
 */
public class DB4OUtil {     

    private static final String FILENAME = "/Users/ethangomes/Downloads/DataBank.db4o";


    private static DB4OUtil dB4OUtil;
        
    public synchronized static DB4OUtil getInstance(){
        if (dB4OUtil == null){
            dB4OUtil = new DB4OUtil();
        }
        return dB4OUtil;
    }

    protected synchronized static void shutdown(ObjectContainer conn) {
        if (conn != null) {
            conn.close();
        }
    }

   private ObjectContainer createConnection() {
        try {
            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            config.file().lockDatabaseFile(false); // Disable file locking
            config.common().activationDepth(Integer.MAX_VALUE);
            config.common().updateDepth(Integer.MAX_VALUE);
            config.common().objectClass(Business.class).cascadeOnUpdate(true);

            return Db4oEmbedded.openFile(config, FILENAME);
        } catch (Exception ex) {
            System.err.println("Error creating connection: " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }




    public synchronized void storeSystem(Business system) {
        ObjectContainer conn = createConnection();
        conn.store(system);
        conn.commit();
        conn.close();
    }
    
    public Business retrieveSystem(){
        ObjectContainer conn = createConnection();
        ObjectSet<Business> systems = conn.query(Business.class); // Change to the object you want to save
        Business system;
        if (systems.size() == 0){
            system = ConfigureABusiness.configure();  // If there's no System in the record, create a new one
        }
        else{
            system = systems.get(systems.size()-1);
        }
        conn.close();
        return system;
    }
}
