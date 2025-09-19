import java.util.HashMap;
import java.util.Map;

class Spreadsheet {
    private Map<String, Integer> cells;
    
    public Spreadsheet(int rows) {
        this.cells = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        if (value == 0) {
            cells.remove(cell);
        } else {
            cells.put(cell, value);
        }
    }
    
    public void resetCell(String cell) {
        cells.remove(cell);
    }
    
    public int getValue(String formula) {
        // Remove the '=' prefix
        String expression = formula.substring(1);
        
        // Split by '+' to get the two operands
        String[] operands = expression.split("\\+");
        String left = operands[0];
        String right = operands[1];
        
        return getOperandValue(left) + getOperandValue(right);
    }
    
    private int getOperandValue(String operand) {
        // Check if operand is a number
        if (isNumeric(operand)) {
            return Integer.parseInt(operand);
        } else {
            // It's a cell reference - return its value (0 if not set)
            return cells.getOrDefault(operand, 0);
        }
    }
    
    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */