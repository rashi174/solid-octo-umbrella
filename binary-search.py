
# Binary Search

def binarySearch(nums,target,low,high):
  if high>=low:
    mid = low+(high-low)//2
    if nums[mid]==target:
      return mid
    elif nums[mid]>target:
      return binarySearch(nums,target,low,mid-1)
    else:
      return binarySearch(nums,target,mid+1,high)
  else:
    return -1

