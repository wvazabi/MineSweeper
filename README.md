# Minesweeper

This project is an implementation of the classic Minesweeper game in Java.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
- [Gameplay](#gameplay)



## Introduction

Minesweeper is a single-player puzzle game. The player needs to clear a hidden "minefield" board containing mines without detonating any of them. The objective is to uncover all safe cells on the board without triggering any mines.

## Features

- Customizable board size
- Random mine placement
- Interactive command-line interface
- Basic input validation
- Win/lose conditions

## Getting Started

To run the Minesweeper game, you need to have Java installed on your computer. Follow these steps:

1. Clone this repository to your local machine (`git clone`).
2. Navigate to the project directory.
3. Compile the Java files (`javac Main.java MineSweeper.java`).
4. Run the game (`java Main`).

## Gameplay

1. When the game starts, you'll be prompted to enter the dimensions (rows and columns) of the game board.
2. Enter the row and column values (must be at least 2).
3. The game will generate a board with randomly placed mines.
4. Enter the coordinates of the cell you want to uncover.
5. If you uncover a mine, the game ends.
6. If you uncover all safe cells, you win the game.


