import java.util.*;

/**
 * This class will take a list of names and determine which combination of two or more names results in a palindrome
 *
 * Created on 11/29/17
 *
 * @author Christopher Brown
 * @version 1.0
 */
public class PalindromeExercise {
  /*
   * List of names to combine into palindromes
   */
  private List<String> potentialPalindromeNames = new ArrayList<>();
  
  /*
   * Palindrome name combinations
   */
  private List<String> palindromeNameCombinations = new ArrayList<>();
  
  /*
   * Add a name to our list of potential palindrome name combinations
   *
   * @param name    The name to add to the list of potential palindrome combinations
   */
  public void addName(final String name) {
    potentialPalindromeNames.add(name);
  }
  
  /*
   * Take a list of names and display them, comma separated, with the corresponding fluff text
   *
   * @param names     The list of names to display, comma separated
   * @param fluffText The fluff text to prepend to the list of names
   */
  private void displayListNames(final List<String> names,
                                final String fluffText) {
    String output = new String();
    Iterator<String> iterator = names.iterator();
    while(iterator.hasNext()) {
      String currentName = iterator.next();
      if(output.length() > 0) {
        output = output.concat(", ");
      }
      output = output.concat(currentName);
    }
    System.out.println(fluffText + output);
  }
    
  /*
   * Loop through the list of potential names to find the combination of two or more names that results in a palindrome
   */
  public void determineAllPalindromes() {
    // First display all the names in our list
    displayListNames(potentialPalindromeNames,
        "The names in our potential palindrome list are: ");
  
    loopForPalindromeFrontToBack(new String(), new HashSet<>());
  
    displayListNames(palindromeNameCombinations,
        "The palindrome combinations are: ");
  }
  
  /*
   * Loop through the list of provided names and recursively check every combination of names for a palindrome
   *
   * @param currentCandidate The current combination of names
   * @param currentSet       The current set of list indexes that have already been processed, so we can skip those indexes
   */
  private void loopForPalindromeFrontToBack(final String currentCandidate,
                                            final Set<Integer> currentSet) {
    // Loop through the entire name list skipping items we've already processed in the set
    for(Integer x=0; x<potentialPalindromeNames.size(); x++) {
      if(currentSet.contains(x)) {
        continue;
      }
      
      // Add the current item to the set of processed indexes
      Set<Integer> newSet = new HashSet<>();
      newSet.addAll(currentSet);
      newSet.add(x);
      
      // Add the current name and check for a palindrome
      String currentName = potentialPalindromeNames.get(x);
      String palindromeCandidate = currentCandidate + currentName;
      if(isPalindrome(palindromeCandidate)) {
        // We found a palindrome so store it
        palindromeNameCombinations.add(palindromeCandidate);
      }
      
      // Recursively loop through the list
      loopForPalindromeFrontToBack(palindromeCandidate, newSet);
    }
  }
  
  /*
   * Check a string against its reverse string
   *
   * @param palindromeCandidate Check if the string is a palindrome
   * @return boolean            True if the string and its reverse are identical (ignoring case),
   *                            False if the string and its reverse are different
   */
  private boolean isPalindrome(final String palindromeCandidate) {
    String reverseCandidate = new StringBuilder(palindromeCandidate).reverse().toString();
    return palindromeCandidate.equalsIgnoreCase(reverseCandidate);
  }
  
  public static void main(String args[]) {
    // HMH provided exercise
    PalindromeExercise palindromeExercise = new PalindromeExercise();
    palindromeExercise.addName("Gimli");
    palindromeExercise.addName("Fili");
    palindromeExercise.addName("Ilif");
    palindromeExercise.addName("Ilmig");
    palindromeExercise.addName("Mark");
    palindromeExercise.determineAllPalindromes();
  }
}
