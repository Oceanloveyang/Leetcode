# -*- coding:utf-8 -*-


# Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
#
# Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
#
# Could you do this in O(n) runtime?
#
# Example:
#
# Input: [3, 10, 5, 25, 2, 8]
#
# Output: 28
#
# Explanation: The maximum result is 5 ^ 25 = 28.
#
#


class Solution(object):
    def findMaximumXOR(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ans = mask = 0
        for x in range(31, -1, -1):
            mask += 1 << x
            prefixSet = set([n & mask for n in nums])
            tmp = ans | 1 << x
            for prefix in prefixSet:
                if tmp ^ prefix in prefixSet:
                    ans = tmp
                    break
        return ans
