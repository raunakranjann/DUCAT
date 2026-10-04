class largeNumber{

    public static void main(String[] args) {
        int sum=0;
        int MaxNum= 0;

         int arr[][]={{10,20,30},{40,50,60},{70,80,90}};

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
                sum = sum +arr[i][j];
                if (arr[i][j]>MaxNum) {
                    MaxNum=arr[i][j];
                }

            }
            System.out.println();
        }
        System.out.println("Sum of the elements of array is " +sum);
        System.out.println("The largest element is "+MaxNum);
    }
}