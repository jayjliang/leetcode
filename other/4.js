/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    let len1 = nums1.length;
    let len2 = nums2.length;
    let middle = [];
    if ((len1 + len2)%2 === 0) {
        middle = [(len1 + len2)/2 -1, (len1 + len2)/2];
    } else {
        middle = [parseInt((len1 + len2)/2)]
    }
    let aindex = 0;
    let bindex = 0;
    let index = 0;
    let result = [];
    while(index < middle.length) {
        if (aindex + bindex === middle[index]) {
            result[index] = Math.min(aindex < len1 ? nums1[aindex] : Infinity, bindex < len2 ? nums2[bindex] : Infinity);
            index++;
        }
        if (aindex < len1 && bindex < len2) {
            if (nums1[aindex] < nums2[bindex]) {
                aindex++;
            } else {
                bindex++;
            }
        } else {
            if (aindex < len1) {
                aindex++;
            }
            if (bindex < len2) {
                bindex++;
            }
        }
    }
    return result.length === 1 ? result[0] : (result[0] + result[1])/2;
};

console.log(findMedianSortedArrays([0,0],[0,0]))