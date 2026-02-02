package edu.eci.arsw.threads;
import java.util.LinkedList;
import java.util.List;
import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;
public class SearchAvailableServer extends Thread {

    private HostBlacklistsDataSourceFacade skds;
    private String ipAddress;
    private List<Integer> occurrences = new LinkedList<>();
    private int start;
    private int end;
    private int checkedCount = 0;

    public SearchAvailableServer(HostBlacklistsDataSourceFacade skds, String ipAddress, int start, int end) {

        this.skds = skds;
        this.ipAddress = ipAddress;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run(){
        for (int i = start; i < end ; i++){
            checkedCount ++;
            if(skds.isInBlackListServer(i, ipAddress)) {
                occurrences.add(i);
            }
        }
    }
    
    public List<Integer> getOccurrences(){
        return occurrences;
    }

    public int getCheckedCount(){
        return checkedCount;
    }
    

}
