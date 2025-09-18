class TaskManager {
    
    // Task class to store task information
    static class Task {
        int userId;
        int taskId;
        int priority;
        
        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }
    
    // Map to store taskId -> Task for O(1) access
    private Map<Integer, Task> taskMap;
    
    // TreeSet to maintain tasks sorted by priority (desc) and taskId (desc) for ties
    private TreeSet<Task> prioritySet;
    
    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        
        // Custom comparator: higher priority first, then higher taskId for ties
        prioritySet = new TreeSet<>((a, b) -> {
            if (a.priority != b.priority) {
                return Integer.compare(b.priority, a.priority); // Higher priority first
            }
            return Integer.compare(b.taskId, a.taskId); // Higher taskId first for ties
        });
        
        // Initialize with given tasks
        for (List<Integer> task : tasks) {
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);
            add(userId, taskId, priority);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        prioritySet.add(task);
    }
    
    public void edit(int taskId, int newPriority) {
        Task oldTask = taskMap.get(taskId);
        
        // Remove old task from priority set
        prioritySet.remove(oldTask);
        
        // Update priority
        oldTask.priority = newPriority;
        
        // Add back to priority set with new priority
        prioritySet.add(oldTask);
    }
    
    public void rmv(int taskId) {
        Task task = taskMap.get(taskId);
        taskMap.remove(taskId);
        prioritySet.remove(task);
    }
    
    public int execTop() {
        if (prioritySet.isEmpty()) {
            return -1;
        }
        
        // Get the highest priority task (first in TreeSet due to our comparator)
        Task topTask = prioritySet.first();
        
        // Remove from both data structures
        prioritySet.remove(topTask);
        taskMap.remove(topTask.taskId);
        
        return topTask.userId;
    }
}