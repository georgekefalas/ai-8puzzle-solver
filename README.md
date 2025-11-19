# AI 8-Puzzle Solver with Diagonal Moves

This repository contains a Java implementation of a variation of the **8-puzzle problem** developed as part of my **Artificial Intelligence course**.  
In this variation, tiles can move **horizontally, vertically, or diagonally** into an adjacent empty space.

The goal is to find the **minimum-cost sequence of moves** from a given initial state to the target state:
6 5 4
7 0 3
8 1 2

The solver implements two algorithms:

- **Uniform Cost Search (UCS)**
- **A* Search** using an admissible heuristic
