pub struct Solution {}

impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> i32 {
        let mut count = 1;
        let mut candidate = &nums[0];

        for el in &nums[1..] {
            if count == 0 {
                candidate = el;
            }

            if *candidate == *el {
                count += 1;
            } else {
                count -= 1;
            }
        }

        *candidate
    }
}
