
public class Section_15_4_StringBuilder {
   
    public static void main(String[] arguments){
        
        String result = "";
        int N = 100;
        
        /**
         * String objects are IMMUTABLE, each call to "result += 'A'" is
         * rewritten as "result = result + 'A'", and once we see that, it
         * is apparent that each String concatenation creates a new String
         * object, As we get further into the loop (A medida que nos adentramos
         * en el bucle), these String objects become more expensive to create,
         * We can estimate the cost of the i-th String concatenation to be
         * "i", so the total cost is O(N^2).
         */
        for(int i = 0; i < N; i++){
            result += 'A';
        }
        
        
        /**
         * The use of an array of characters works only if we know the ﬁnal
         * size of the String, otherwise, we have to use something like
         * "ArrayList<char>", This results in a linear-time algorithm that
         * executes in the blink of the eye.
         */
        char[ ] theChars = new char[N];
        for(int i = 0; i < N; i++){
            theChars[i] = 'A';
        }
        result = new String(theChars);
        
        
        /**
         * Some String concatenations, such as those in a single expression,
         * are optimized by the compiler to avoid repeated creations of Strings,
         * but if your concatenations are intermingled with other statements,
         * as is the case here, then you often can use a StringBuilder for
         * more efﬁcient code, this code is linear-time and runs quickly.
         */
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append( 'A' );
        }
        result = new String(sb);
    }
}
