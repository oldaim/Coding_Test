```java
    int lower_bound(int A[], int L, int R, int X) {
        int ans = R + 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] >= X) {
                ans = mid;
                R = mid - 1;
            }
            else {
                L = mid + 1;
            }
        }
            return ans;
    }

    int upper_bound(int A[], int L, int R, int X) {
    int ans = R + 1;
    while (L <= R) {
        int mid = (L + R) / 2;
        if (A[mid] > X) {
            ans = mid;
            R = mid - 1;
        }
        else {
            L = mid + 1;
            }
        }
        return ans;
    }
```