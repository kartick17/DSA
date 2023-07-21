package Stack;

import java.util.Stack;

public class NextSmallerElement {

    int[] findNextSmallerElement (int[] p) {
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[p.length];
        st.push(-1);

        for(int i = p.length-1; i >= 0; i--) {
            while (p[i] < st.peek())
                st.pop();

            arr[i] = st.peek();
            st.push(p[i]);
        }

        return arr;
    }

    public static void main(String[] args) {

        NextSmallerElement obj = new NextSmallerElement();
        int arr[] = {4, 8, 5, 3, 23};
        int ans[] = obj.findNextSmallerElement(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
