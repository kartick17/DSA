package Stack;

import java.util.Stack;

public class PreviousSmallerElement {

    int[] findSmallerElement(int[] element) {
        int[] arr = new int[element.length];
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for (int i = 0; i < element.length; i++) {
            while (st.peek() > element[i]) {
                st.pop();
            }
            arr[i] = st.peek();
            st.push(element[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        PreviousSmallerElement obj = new PreviousSmallerElement();
        int arr[] = {4, 8, 5, 2, 20};
        int ans[] = obj.findSmallerElement(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
