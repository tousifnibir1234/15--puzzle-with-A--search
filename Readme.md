# Solving 15-puzzle by A* search

###  Input:
 The input is a text file. The first line contains an integer n which indicates there are (n-1) problems to besolved. The second line describes the goal state.
The following (n-1) lines describe initial states, one initial state per line. Overall, the input file has (n+1) lines.
For this assignment, we assume the goal state is going to be the standard goal state: the integers are in consecutive order with the blank space in the bottom
right corner. We also assume the blank state is described as a zero. So, the goal state is described by [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0]

### Output:
 The output should show the sequence of steps from the initial state to the goal state. Two heuristics (the misplaced tiles and the Manhattan distance)
should be used. The output should mention the path cost. Since both the heuristics are admissible, we would obtain the path with the same cost. To find
contrast, the output should print the number of expanded nodes (the size of the closed list) during the search. 




### check assignment1.pdf for details