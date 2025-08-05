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


    public boolean isPalindrome(String word ){
        Deque<Character> deque = wordToDeque(word);
        CharacterComparator comparator = new OffByN(0);
        return isPalindrome(deque , comparator);

    }
    public boolean isPalindrome(String word , CharacterComparator cc){
        Deque<Character> deque = wordToDeque(word);
        return isPalindrome(deque , cc);

    }

//    private boolean isPalindrome(Deque<Character> deque){
//        if(deque.isEmpty() || deque.size() ==1) return true;
//
//        Character front = deque.removeFirst();
//        Character back = deque.removeLast();
//        return front.equals(back) && isPalindrome(deque);
//    }
//}


    private boolean isPalindrome(Deque<Character> deque , CharacterComparator cc){
    if(deque.isEmpty() || deque.size() ==1) return true;
    if(!cc.equalChars(deque.removeFirst(),deque.removeLast()))
        return false;

    return isPalindrome(deque , cc);
    }
 }
