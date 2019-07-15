package get2019Assignment;
/*@class JobScheduler 
 * JobScheduler class contain some basic function like
 * @func getturnAroundTimeOfEachProcess
 * @func getWatingTimeOfEachProcess
 * @func getWatingTimeOfEachProcess
 * @func getAverageWatingTimeOfProcess
 * @func getMaxWatingTimeOfProcess
 * this all function take some array as parameter and reurn array or single value
 * class is used to find the sheduling of job how much time they are taking to 
 * complete how much they are in wait state how much there turn around time and average wating time of 
 * all process and max waiting time of process
 * 
 */
public class JobScheduler{
	/*@func getCompletionTimeOfEachProcess
	 * this function is used to find complete time each process 
	 * how much time the process take complete in scheduling
	 * @param jobSchedulingTable take contain all arrival time and brust time of process
	 * in 2d array 
	 *  
	 */
	public int[] getCompletionTimeOfEachProcess(int[][] jobSchedulingTable){
		int sizeOfCompletionTime=jobSchedulingTable.length;
		int firstJobArrivalTime=jobSchedulingTable[0][0];
		System.out.println("First"+firstJobArrivalTime);
		int completionTimeOfEachProcess[] = new int[sizeOfCompletionTime];
		
		for(int i=0;i<sizeOfCompletionTime;i++){
			for(int j=0;j<2;j++){
				if(j==1){
					if(i==0){//if(i==1) check that the job is first 
						//so it add the arrival time and brust time of process directly
						completionTimeOfEachProcess[i]=firstJobArrivalTime+jobSchedulingTable[i][j]; //completionTime=arrival+brustTime for 1 process
						firstJobArrivalTime=firstJobArrivalTime+jobSchedulingTable[i][j]; //update the first job arrival time
					}else{
						
						if(completionTimeOfEachProcess[i-1]>jobSchedulingTable[i][j-1]){
							//this condtion specify that if process is not idea so same calculation start	
							completionTimeOfEachProcess[i]=firstJobArrivalTime+jobSchedulingTable[i][j];
							firstJobArrivalTime=firstJobArrivalTime+jobSchedulingTable[i][j];
						}else{
							//if(completionTimeOfEachProcess>jobSchedulingTable) this conditon check that
							//if process is idea so it also add how much time it is ideal			
							completionTimeOfEachProcess[i]=(jobSchedulingTable[i][j-1]-completionTimeOfEachProcess[i-1])+firstJobArrivalTime+jobSchedulingTable[i][j];
							firstJobArrivalTime=(jobSchedulingTable[i][j-1]-completionTimeOfEachProcess[i-1])+firstJobArrivalTime+jobSchedulingTable[i][j];
						}
					}
				}
			}
		}
				
		return completionTimeOfEachProcess;
	}
	/*@func getturnAroundTimeOfEachProcess this function find the turn arround time of each process
	 * @param jobSchedulingTable this parameter containg all arrival time and brust time of process in 2d array
	 * @param completeTimeOfEachProcess this param contain all completion time of each process
	 * $turn around time=completeTime-arrival time
	 */
	public int[] getturnAroundTimeOfEachProcess(int[][] jobSchedulingTable , int[] completeTimeOfEachProcess){
		
		int turnAroundTimeOfEachProcess[]= new int[jobSchedulingTable.length];
		
		int sizeOfturnAroundTime=jobSchedulingTable.length;
		System.out.println();
		for(int i=0;i<sizeOfturnAroundTime;i++){
			
			for(int j=0;j<2;j++){
				
				if(j==0){ //this condtion say if array come at arrival so insert else ignore
					
					turnAroundTimeOfEachProcess[i]=completeTimeOfEachProcess[i]-jobSchedulingTable[i][j];
					
				}
			}
		}
		
		return turnAroundTimeOfEachProcess;
	}
	
	/*@func getWatingTimeOfEachProcess this function find the wating  time of each process
	 * @param jobSchedulingTable this parameter containg all arrival time and brust time of process in 2d array
	 * @param turnAroundTimeOfEachProcess this param contain all turn around time of each process
	 * $wating time = turnaroundTime-brust time
	 */
	public int[] getWatingTimeOfEachProcess(int[][] jobSchedulingTable , int[] turnAroundTimeOfEachProcess){
		
		int watingTimeOfEachProcess[]= new int[jobSchedulingTable.length];
		
		int sizeOfWatingTime=jobSchedulingTable.length;
		System.out.println();
		for(int i=0;i<sizeOfWatingTime;i++){
			
			for(int j=0;j<2;j++){
				
				if(j==1){
					
					watingTimeOfEachProcess[i]=turnAroundTimeOfEachProcess[i]-jobSchedulingTable[i][j];
					//watingtime=(turnAroundTimeOfEachProcess[i]-jobSchedulingTable[i][j]));
					
				}
			}
		}
		
		return watingTimeOfEachProcess;
	
	/*@func getAverageWatingTimeOfProcess this fucntion is used to calculate the average wating time of all process
	 * @param watingTimeOfEachProcess this param is one D array which contain all wating time of process
	 * @averageWating=sum of all process/how much process are there
	 */
	public double getAverageWatingTimeOfProcess(int[] watingTimeOfEachProcess) {
		double averageWatingTime=0;
		for(int i=0;i<watingTimeOfEachProcess.length;i++){
			
			averageWatingTime=averageWatingTime+watingTimeOfEachProcess[i];
		}
		
		return averageWatingTime/watingTimeOfEachProcess.length;
	}

	/*@func getMaxWatingTimeOfProcess this fucntion is used to calculate the maximum wating time of  process from all
	 * @param watingTimeOfEachProcess this param is one D array which contain all wating time of process
	 * @maxwating=check max(watingTimeOfEachProcess)
	 */
	public int getMaxWatingTimeOfProcess(int[] watingTimeOfEachProcess){
		
		int maxWatingTime=watingTimeOfEachProcess[0];
		
		for(int i=0;i<watingTimeOfEachProcess.length;i++){
			
			if(maxWatingTime<watingTimeOfEachProcess[i]){
				//this condtion check that the @param maxWatingTime is contain value of first index of array
				//maxWatingTime=watingTimeOfEachProcess[0] we assume as this is max value 
				//we check every value with if value is less then update it
				maxWatingTime=watingTimeOfEachProcess[i];
			}
		}
		
		return maxWatingTime;
	}
	
}
