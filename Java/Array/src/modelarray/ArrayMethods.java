package modelarray;

public class ArrayMethods {
    public void printArray(int[] tabel) {
        System.out.print("{");
        for (int i = 0; i < tabel.length; i++) {
            if (i == 0) {
                System.out.print(tabel[i]);
            }
            else {
                System.out.print(", " + tabel[i]);
            }
        }
        System.out.println("}  ");
    }

    /**
     *
     * @return et array med indhold [0,0,0,0,0,0,0,0,0,0]
     */
    public int[] fyldArrayA() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++) {
        	result[i] = 0;
        }
        return result;
    }
    
    /**
     *
     * @return et array med indhold [2,44,-23,99,8,-5,7,10,20,30]
     */
    public int[] fyldArrayB() {
        int[] result = new int[10];
        int[] temp = {2,44,-23,99,8,-5,7,10,20,30};
        result = temp;
        return result;
    }
    
    /**
     *
     * @return et array med indhold [0,1,2,3,4,5,6,7,8,9]
     */
    public int[] fyldArrayC() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++) {
        	result[i] = i;
        }
        return result;
    }

    /**
     *
     * @return et array med indhold [2,4,6,8,10,12,14,16,18,20]
     */
    public int[] fyldArrayD() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++) {
        	result[i] = 2 + i * 2;
        }
        return result;
    }

    /**
     *
     * @return et array med indhold [1,4,9,16,25,36,49,64,81,100]
     */
    public int[] fyldArrayE() {
    	int b = 1;
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++) {
        	result[i] = b * b;
        	b++;
        }
        return result;
    }

    /**
     *
     * @return et array med indhold [0,1,0,1,0,1,0,1,0,1]
     */
    public int[] fyldArrayF() {
    	int j = 0;
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++) {
        	if (j == 1) {
        		result[i] = j;
        		j--;
        	} else {
        		result[i] = j;
        		j++;
        	}
        	
        }
        return result;
    }

    /**
     *
     * @return et array med indhold [0,1,2,3,4,0,1,2,3,4]
     */
    public int[] fyldArrayG() {
    	int j = 0;
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++) {
        	if (j <= 4) {
        		result[i] = j;
        		j++;
        	} else if(j > 4) {
        		j = 0;
        		j++;
        	}
        }
        return result;
    }
    
    public int findMax(int[] tabel) {
        int max = -1;
        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i] > max) {
                max = tabel[i];
            }
        }
        return max;
    }
    
    public int sum(int[] t) {
    	int sum = 0;
    	for (int i = 0; i < t.length; i++) {
    		sum += t[i];
    	}
    	return sum;
    }
    public double dsum(double[] t) {
    	double sum = 0;
    	for (int i = 0; i < t.length; i++) {
    		sum += t[i];
    	}
    	return sum;
    }
    
    public int[] makeSum (int[] a, int[] b) {
    	int length = Math.max(a.length, b.length);
    	int[] sum = new int[length];
    	for (int i = 0; i < sum.length; i++) {
    		if (a.length > i && b.length > i) {
    		sum[i] = a[i] + b[i];
    		} else if(a.length > i) {
    			sum[i] = a[i];
    		} else {
    			sum[i] = b[i];
    		}
    	}
    	return sum;
    }
    
    public boolean hasUneven(int[] t) {
    	boolean result = false;
    	for (int element : t) {
    		if (element % 2 == 0) {
    		} else {
    			result = true;
    		}
    	}
    	return result;
    }
}
