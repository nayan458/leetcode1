class TaskManager {

    private PriorityQueue<Task> q;
    private Map<Integer, Task> hm;

    private Comparator<Task> cmp = (a,b) -> {
        if(a.priority != b.priority)
            return Integer.compare(b.priority,a.priority);
        if(a.taskId != b.taskId)
            return Integer.compare(b.taskId,a.taskId);
        return Long.compare(b.order,a.order);
    };

    public TaskManager(List<List<Integer>> tasks) {
        this.q = new PriorityQueue<>(cmp);
        this.hm = new HashMap<>();

        for(List<Integer> elem: tasks)
            add(elem.get(0), elem.get(1), elem.get(2));
    }
    
    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        q.add(task);
        hm.put(taskId, task);
    }
    
    public void edit(int taskId, int newPriority) {
        Task task = hm.remove(taskId);
        Task updatedTask = new Task(task.userId, taskId, newPriority);
        q.add(updatedTask);
        hm.put(taskId, updatedTask);
    }
    
    public void rmv(int taskId) {
        hm.remove(taskId);
    }
    
    public int execTop() {
        while(!q.isEmpty()){
            Task task = q.poll();
            Task taskInHm = hm.get(task.taskId);
            if(taskInHm == null || task.priority != taskInHm.priority) continue;
            hm.remove(task.taskId);
            return task.userId;
        }
        return -1;
    }
}

class Task {
    int userId; int taskId; int priority;
    long order;
    static long count = 0;
    

    public Task(int userId, int taskId, int priority){
        this.userId = userId; 
        this.taskId = taskId; 
        this.priority = priority;
        this.order = count++;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task other = (Task) o;
        return userId == other.userId &&
            taskId == other.taskId &&
            priority == other.priority;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(userId, taskId, priority);
    }

}