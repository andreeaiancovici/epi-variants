The original Elements of Programming Interviews repository can be found [here](https://github.com/adnanaziz/EPIJudge). <br/>
The book containing the problems can be found here [Elements of Programming Interviews](http://amzn.to/2pMWIWH).

# Elements of Programming Interviews (Java)
This repository contains solutions with detailed explanations for exercises from <b>Elements Of Programming Interviews</b> by Adnan Aziz, Tsung-Hsien Lee, and Amit Prakash. <br/>
Additionaly, there are some proposed solutions to variant exercises and matching problems from [LeetCode](https://leetcode.com/).

## Primitive Types

| Problem | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LeetCode&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; | Variants |
| ------- | -------- | -------- |
| [Bootcamp: CountBits](/src/main/java/epi/primitive/CountBits.java) | <a href="https://leetcode.com/problems/counting-bits/"><img src="https://img.shields.io/badge/easy-Counting%20Bits-brightgreen" /></a> | |
| [5.1 Parity ](/src/main/java/epi/primitive/_5/_1/Parity.java)| <a href="https://leetcode.com/problems/number-of-1-bits/"><img src="https://img.shields.io/badge/easy-Number%20of%201%20Bits-brightgreen" /></a> | |
| [5.2 SwapBits](/src/main/java/epi/primitive/_5/_2/SwapBits.java) | | |
| [5.3 ReverseBits](/src/main/java/epi/primitive/_5/_3/ReverseBits.java) | <a href="https://leetcode.com/problems/reverse-bits/"><img src="https://img.shields.io/badge/easy-Reverse%20Bits%20-brightgreen" /></a> | |
| [5.4 ClosestIntSameWeight](/src/main/java/epi/primitive/_5/_4/ClosestIntSameWeight.java) | | [ClosestIntSameWeightConstantTime](/src/main/java/epi/primitive/_5/_4/variant/ClosestIntSameWeightConstantTime.java) |
| [5.5 PrimitiveMultiply](/src/main/java/epi/primitive/_5/_5/PrimitiveMultiply.java) | | |
| [5.6 PrimitiveDivide](/src/main/java/epi/primitive/_5/_6/PrimitiveDivide.java) | | |
| [5.7 PowerXY](/src/main/java/epi/primitive/_5/_7/PowerXY.java) | <a href="https://leetcode.com/problems/powx-n/"><img src="https://img.shields.io/badge/medium-Pow(x%2C%20n)-orange" /></a> | |
| [5.8 ReverseDigits](/src/main/java/epi/primitive/_5/_8/ReverseDigits.java) | <a href="https://leetcode.com/problems/reverse-integer/"><img src="https://img.shields.io/badge/medium-Reverse%20Integer-orange" /></a> | |
| [5.9 IsNumberPalindromic](/src/main/java/epi/primitive/_5/_9/IsNumberPalindromic.java) | <a href="https://leetcode.com/problems/palindrome-number/"><img src="https://img.shields.io/badge/easy-Palindrome%20Number-brightgreen" /></a> | |
| [5.10 UniformRandomNumber](/src/main/java/epi/primitive/_5/_10/UniformRandomNumber.java) | <a href="https://leetcode.com/problems/implement-rand10-using-rand7/"><img src="https://img.shields.io/badge/medium-%20Implement%20Rand10()%20Using%20Rand7()-orange" /></a> | |
| [5.11 RectangleIntersection](/src/main/java/epi/primitive/_5/_11/RectangleIntersection.java) | <a href="https://leetcode.com/problems/rectangle-overlap/"><img src="https://img.shields.io/badge/easy-Rectangle%20Overlap-brightgreen" /></a> | [FourPointsFormRectangle](/src/main/java/epi/primitive/_5/_11/variant/FourPointsFormRectangle.java)<br/>❌ [RectangleIntersectionNotAlignedXY](/src/main/java/epi/primitive/_5/_11/variant/RectangleIntersectionNotAlignedXY.java) <b style='color:red'>(todo)<b/> |

## Arrays
| Problem | &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LeetCode&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; | Variants |
| ------- | -------- | -------- |
| [Bootcamp: EvenOddArray](/src/main/java/epi/arrays/EvenOddArray.java) | <a href="https://leetcode.com/problems/sort-array-by-parity/"><img src="https://img.shields.io/badge/easy-Sort%20Array%20By%20Parity-brightgreen" /></a> | |
| [6.1 DutchNationalFlag](/src/main/java/epi/arrays/_6/_1/DutchNationalFlag.java) | <a href="https://leetcode.com/problems/sort-colors/"><img src="https://img.shields.io/badge/medium-Sort%20Colors-orange" /></a> | [DutchNationalFlagWithoutPivot](/src/main/java/epi/arrays/_6/_1/variant/DutchNationalFlagWithoutPivot.java)<br/>[MauritiusNationalFlag](/src/main/java/epi/arrays/_6/_1/variant/MauritiusNationalFlag.java)<br/>[BooleanValuedKeysFlag](/src/main/java/epi/arrays/_6/_1/variant/BooleanValuedKeysFlag.java)<br/>[BooleanValuedKeysFlagWithRelativeTrueOrder](/src/main/java/epi/arrays/_6/_1/variant/BooleanValuedKeysFlagWithRelativeTrueOrder.java)|
| [6.2 IntAsArrayIncrement](/src/main/java/epi/arrays/_6/_2/IntAsArrayIncrement.java) | <a href="https://leetcode.com/problems/plus-one/"><img src="https://img.shields.io/badge/easy-Plus%20One-brightgreen" /></a> | [AddBinary](/src/main/java/epi/arrays/_6/_2/variant/AddBinary.java) |
| [6.3 IntAsArrayMultiply](/src/main/java/epi/arrays/_6/_3/IntAsArrayMultiply.java) | | |
| [6.4 AdvanceByOffsets](/src/main/java/epi/arrays/_6/_4/AdvanceByOffsets.java) | <a href="https://leetcode.com/problems/jump-game/"><img src="https://img.shields.io/badge/medium-Jump%20Game-orange" /></a> | [MinimumStepsAdvanceByOffsets](/src/main/java/epi/arrays/_6/_4/variant/MinimumStepsAdvanceByOffsets.java) |
| [6.5 SortedArrayRemoveDups](/src/main/java/epi/arrays/_6/_5/SortedArrayRemoveDups.java) | <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/"><img src="https://img.shields.io/badge/easy-Remove%20Duplicates%20from%20Sorted%20Array-brightgreen" /></a> | [ArrayRemoveKey](/src/main/java/epi/arrays/_6/_5/variant/ArrayRemoveKey.java)<br/>[SortedArrayMTimes](/src/main/java/epi/arrays/_6/_5/variant/SortedArrayMTimes.java) |
| [6.6 BuyAndSellStock](/src/main/java/epi/arrays/_6/_6/BuyAndSellStock.java) | <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/"><img src="https://img.shields.io/badge/easy-Best%20Time%20to%20Buy%20and%20Sell%20Stock-brightgreen" /></a> | [LongestSubArrayWithEqualEntries](/src/main/java/epi/arrays/_6/_6/variant/LongestSubArrayWithEqualEntries.java)|
| ❌[6.6 BuyAndSellStockTwice](/src/main/java/epi/arrays/_6/_7/BuyAndSellStockTwice.java) <b style='color:red'>(todo)<b/> | <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/"><img src="https://img.shields.io/badge/hard-Best%20Time%20to%20Buy%20and%20Sell%20Stock%20III-red" /></a> | [BuyAndSellStockTwiceLinearTime](/src/main/java/epi/arrays/_6/_7/variant/BuyAndSellStockTwiceLinearTime.java) |
| [6.8 PrimeSieve](https://github.com/andreeaiancovici/ElementsOfProgrammingInterviews-Variants/blob/main/src/main/java/epi/arrays/PrimeSieve.java) | :yellow_heart:&nbsp;[Count Primes](https://leetcode.com/problems/count-primes/) | |
| [6.9 ApplyPermutation](https://github.com/andreeaiancovici/ElementsOfProgrammingInterviews-Variants/blob/main/src/main/java/epi/arrays/ApplyPermutation.java) | | |
| [6.10 NextPermutation](https://github.com/andreeaiancovici/ElementsOfProgrammingInterviews-Variants/blob/main/src/main/java/epi/arrays/NextPermutation.java) | :yellow_heart:&nbsp;[Next Permutation](https://leetcode.com/problems/next-permutation/) | |
| [6.11 OfflineSampling](https://github.com/andreeaiancovici/ElementsOfProgrammingInterviews-Variants/blob/main/src/main/java/epi/arrays/OfflineSampling.java) | | |
| [6.12 OnlineSampling](https://github.com/andreeaiancovici/ElementsOfProgrammingInterviews-Variants/blob/main/src/main/java/epi/arrays/OnlineSampling.java) | | |
| [6.13 RandomPermutation](https://github.com/andreeaiancovici/ElementsOfProgrammingInterviews-Variants/blob/main/src/main/java/epi/arrays/RandomPermutation.java) | :yellow_heart:&nbsp;[Shuffle an Array](https://leetcode.com/problems/shuffle-an-array/) | |
| 6.14 RandomSubset - TO-DO | | |
| [6.15 NonuniformRandomNumber](https://github.com/andreeaiancovici/ElementsOfProgrammingInterviews-Variants/blob/main/src/main/java/epi/arrays/NonuniformRandomNumber.java) | | |

## Multidimensional Arrays
| Problem | LeetCode | Variants |
| ------- | -------- | -------- |
| [6.16 IsValidSudoku](https://github.com/andreeaiancovici/ElementsOfProgrammingInterviews-Variants/blob/main/src/main/java/epi/multidimensionalarrays/IsValidSudoku.java) | :yellow_heart:&nbsp;[Valid Sudoku](https://leetcode.com/problems/valid-sudoku/) | |
| [6.17 SpiralOrderingSegments](https://github.com/andreeaiancovici/ElementsOfProgrammingInterviews-Variants/blob/main/src/main/java/epi/multidimensionalarrays/SpiralOrderingSegments.java) | :yellow_heart:&nbsp;[Spiral Matrix](https://leetcode.com/problems/spiral-matrix/) | |
| [6.18 MatrixRotation](https://github.com/andreeaiancovici/ElementsOfProgrammingInterviews-Variants/blob/main/src/main/java/epi/multidimensionalarrays/MatrixRotation.java) | :yellow_heart:&nbsp;[Rotate Image](https://leetcode.com/problems/rotate-image/) | |
| [6.19 PascalTriangle](https://github.com/andreeaiancovici/ElementsOfProgrammingInterviews-Variants/blob/main/src/main/java/epi/multidimensionalarrays/PascalTriangle.java) | :green_heart:&nbsp;[Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/) | |

# In progress...

## Strings

|Problem|LeetCode|Level|Similar questions|Variants
|---|---|---|---|---|
|7.4 Replace and remove| | | |TelexEncoding, MergeTwoSortedArrays|
|7.5 Test palindromicity|https://leetcode.com/problems/valid-palindrome/|:green_heart:&nbsp;**Easy**|Valid Palindrome II, Palindrome Linked List| |
|7.6 Reverse all the words in a sentence|https://leetcode.com/problems/reverse-words-in-a-string/|:yellow_heart:&nbsp;**Medium**|Reverse Words in a String II| |
|7.7 Compute all mnemonics for a phone number|https://leetcode.com/problems/letter-combinations-of-a-phone-number/|:yellow_heart:&nbsp;**Medium**|Generate Parentheses, Combination Sum, Binary Watch| |
