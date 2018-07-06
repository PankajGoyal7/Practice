public class ReplaceZeroToGetOnes 
{
    public int getRequiredIndex(int[] binaryArray)
    {
        int prevZeroIndex = -1, prevPrevZeroIndex = -1;
        int maxLength = -1, requiredIndex = -1, currLength = -1;
 
        for (int i = 0; i < binaryArray.length; i++)
        {
            if (binaryArray[i] == 0)
            {
                if (prevPrevZeroIndex != -1)
                {
                    currLength = i - prevPrevZeroIndex - 1;
                    if (currLength > maxLength)
                    {
                        maxLength = currLength;
                        requiredIndex = i;
                    }
                }
                prevPrevZeroIndex = prevZeroIndex;
                prevZeroIndex = i;
            }
        }
         
        // if number of 0s is less than 3
        if (maxLength == -1)
        {
            if (prevPrevZeroIndex != -1) // if there are two 0s
            {
                // the length of 1s sequence after replacing 0 at 'prevPrevZeroIndex' would be 'prevZeroIndex'
                // and the length of 1s sequence after replacing 0 at 'prevZeroIndex' would be (binaryArray.length - prevPrevZeroIndex - 1) 
                if (prevZeroIndex > (binaryArray.length - prevPrevZeroIndex - 1))
                {
                    requiredIndex = prevPrevZeroIndex;
                }
                else
                {
                    requiredIndex = prevZeroIndex;
                }
            }
            else // if there is one or no 0s present 
            {
                requiredIndex = prevZeroIndex;
            }
        }
        return requiredIndex;
    }
     
    public static void main(String[] args)
    {
        ReplaceZeroToGetOnes solution = new ReplaceZeroToGetOnes(); 
         
        int [] binaryArray = {1,1,0,0,1,0,1,1,1,0,1,1,1};
         
        System.out.println(solution.getRequiredIndex(binaryArray));       
    }
}