---
name: generate-main
description: Fill in the main method of a Java DSA solution file with one example input (usually the problem's standard LeetCode example). Use this whenever the user asks to generate, write, add or fill in a main method, test data, a test example or sample input for "the current file", "this file" or a named solution class, even if they don't say "skill". It only writes main. It never compiles or runs anything, and never reviews, fixes or suggests changes to the solution.
---

# Generate main

The user practises DSA problems in this repo. They write each solution themselves and run it themselves. Your only job is to fill in `main` with one realistic example, so they have something to run.

**Only write `main`. Don't compile, run or review anything.** The user is practising, so running the code and checking the result is their part of the exercise. Running it for them would show them the answer before they've had a chance to check their own work. For the same reason, they want to find bugs and improvements themselves, and they ask for a review separately when they want one. Even if you notice a bug, a likely crash, an inefficiency, an unused variable, a leftover debug print or odd naming, don't fix it, don't mention it and don't offer to look into it.

## 1. Find the target file

- Use the file the user names. Otherwise use the file they currently have open in the IDE (the most recent "user opened the file …" note).
- If neither tells you which file, ask. Don't guess from git status.

## 2. Read the file and decide what to test

Read the whole file and work out:

- **The method to test.** This is the public solution method, such as `reverseKGroup` or `isValid`. If there are several alternative solutions (for example `mergeKLists` and `mergeKListsDivideAndConquer`), call each one. Build a fresh copy of the input for each call, because many solutions rewire nodes or change arrays in place.
- **The problem.** The class name is usually the LeetCode problem name, for example `ReverseNodesInKGroup` is LeetCode 25. Use that problem's first official example as the input, and its official output as the expected result. If you don't recognise the problem, pick a small input of 3 to 6 elements that exercises the method, and work out the expected output by hand.
- **The current state of `main`.**
  - `main` is empty, or only creates the solution object: fill it in, and keep any existing lines.
  - `main` already calls the method: ask the user whether to replace that example or add another one.
  - There is no `main`: add `static void main()` as the first member of the class. This is the convention in the user's recent files.

## 3. Write `main` in the repo's style

Match the other `main` methods in the same folder. These are the conventions:

```java
static void main() {
    ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    ListNode result = reverseNodesInKGroup.reverseKGroup(head, 2);
    while (result != null) {
        System.out.print(result.val + " -> ");
        result = result.next;
    }
}
```

- **Signature.** Keep whatever signature the file already has (`static void main()` or `public static void main(String[] args)`). Both work on this repo's JDK.
- **Solution object.** Create the solution object first, in the form `ClassName className = new ClassName();`.
- **Linked lists.** Chain the nodes with `head.next.next = …`, as above, then print with the `while` loop that prints `val + " -> "`.
- **Lists that share nodes,** such as an intersection or a cycle. Build the shared part once and attach it to both lists. Comparisons are by reference, so equal values in separate nodes are not the same node. Print the meaningful result, for example `"Intersected at " + result.val`.
- **Trees.** Assign `root.left`, `root.right`, `root.left.left` and so on, grouped by level with a blank line between levels. Print the result with `System.out.println`, or with `TreeNode.printTree(root)` when the method returns a tree.
- **Arrays and strings.** Use a local variable with a literal, for example `int[] nums = {1, 3, 4, 2, 2};` or `String s = "()[]{}";`. Print arrays with `Arrays.toString`.
- **`void` methods that change their input.** Print the input after the call.
- **Design problems** (`LRUCache`, `MinStack`, …). Replay the official example's sequence of operations, printing each return value.
- **Shared classes.** Use the existing helper classes: `ListNode` (`com.dsa.patterns.linkedlist`), `TreeNode` (`com.dsa.patterns.trees`), `Node` (`com.dsa.patterns.graphs`) and `TrieNode` (`com.dsa.patterns.trie`). If the file is in a different package, use only their `public` constructors, such as `new ListNode(val)` and `new TreeNode(val)`. `ListNode()`, `TreeNode()` and `TreeNode(val, left, right)` are package-private.

Change nothing outside `main` except adding an `import` that `main` needs, such as `java.util.Arrays` or `ListNode` from another package. Don't reformat the file, reorder anything, or touch the solution method or other helpers.

Since you won't compile it, check by reading that your `main` would compile: every type it uses is imported, every constructor it calls is public or in the same package, and the method name and parameter types match the solution's signature.

## 4. Report

Keep the report short:

- Which file you added the example to. Name it if you inferred it from the IDE.
- The input and the expected output, so the user knows what to compare against when they run it.

That's the whole report. Don't say whether the solution looks right, and don't add anything about the solution code.

**Example report:**

> I added a test to `main` in `ReverseNodesInKGroup.java`, using the standard LeetCode example:
> - Input: `1 -> 2 -> 3 -> 4 -> 5`, with `k = 2`
> - Expected: `2 -> 1 -> 4 -> 3 -> 5 ->`
