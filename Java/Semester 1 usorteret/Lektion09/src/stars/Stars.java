package stars;

public class Stars {
    final int MAX_ROWS = 10;

    /*
    public void starPicture() {
        for (int row = 1; row <= MAX_ROWS; row++) {
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }
    */

    public void starPictureA() {
        for (int linje = 1; linje <= MAX_ROWS; linje++) {
        	for (int star = 1; star <= linje; star++) {
        		System.out.print("*");
        	}
        	System.out.println();
        }
        System.out.println();
    }

    public void starPictureB() {
        for (int linje = 1; linje <= MAX_ROWS; linje++) {
        	for (int notStar = 9; notStar >= linje; notStar--) {
        		System.out.print(" ");
        	}
        	for (int star = 1; star <= linje; star++) {
        		System.out.print("*");
        	}
        	System.out.println();
        }
		System.out.println();
    }

    public void starPictureC() {
        for (int linje = 1; linje <= MAX_ROWS; linje++) {
        	for (int notStar = 0; notStar <= linje; notStar++) {
        		System.out.print(" ");
        	}
        	for (int star = 10; star >= linje; star--) {
        		System.out.print("*");
        	}
        	System.out.println();
        }
        System.out.println();
    }

    public void starPictureD() {
        for (int linje = 1; linje <= MAX_ROWS; linje++) {
        	if (linje <= 5) {
        		for (int notStar = 4; notStar <= linje; notStar--) {
            		System.out.print(" ");
            	}
            	for (int star = 1; star <= linje; star = star + 2) {
            		System.out.print("*");
            	}
            	for (int notStar = 4; notStar <= linje; notStar--) {
            		System.out.print(" ");
            	}
            	System.out.println();
        	} else if (linje > 5 && linje <= MAX_ROWS){
        		for (int notStar = 1; notStar <= linje; notStar++) {
            		System.out.print(" ");
            	}
            	for (int star = 9; star >= linje; star = star - 2) {
            		System.out.print("*");
            	}
            	for (int notStar = 1; notStar <= linje; notStar++) {
            		System.out.print(" ");
            	}
            	System.out.println();
        	}
        }
    }

}
