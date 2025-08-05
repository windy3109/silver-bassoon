import java.util.LinkedList;

public class Palindrome {
    public Deque<Character> wordToDeque(String word){

        char[] chars = word.toCharArray();
        LinkedListDeque<Character> deque = new LinkedListDeque<>();
        for(char c : chars){
            deque.addLast(c);
        }
        return deque;

    }


    public boolean isPalindrome(String word , CharacterComparator cc){
        Deque<Character> deque = wordToDeque(word);
        return isPalindrome(deque , cc);

    }

//    private boolean isPalindrome(Deque<Character> deque , CharacterComparator cc){
//        if(deque.isEmpty() || deque.size() ==1) return true;
//
//        Character front = deque.removeFirst();
//        Character back = deque.removeLast();
//        return cc.equalChars(front , back) && isPalindrome(deque , cc);
//    }
//}


    private boolean isPalindrome(Deque<Character> deque , CharacterComparator cc){
    if(deque.isEmpty() || deque.size() ==1) return true;
    if(!cc.equalChars(deque.removeFirst(),deque.removeFirst()))
        return false;

    return isPalindrome(deque , cc);
    }
 }
