#!/usr/bin/env python
# coding: utf-8

# In[1]:


def my_sq_prod(numbers):
    return_value = 1
    for number in numbers:
        return_value *= number ** 2
    return return_value

def score_check():
    score = 0
    if my_sq_prod([1,2,3]) == 36:
        score += 30
    print(score)

if __name__ == "__main__":
    score_check()

