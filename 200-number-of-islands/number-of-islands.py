class Solution(object):
    def updateIsland(self, grid, i, j):
        # Base condition to stop recursion
        if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] != '1':
            return

        # Mark the current cell as visited
        grid[i][j] = '0'

        # Explore all 4 directions
        self.updateIsland(grid, i - 1, j)  # up
        self.updateIsland(grid, i + 1, j)  # down
        self.updateIsland(grid, i, j - 1)  # left
        self.updateIsland(grid, i, j + 1)  # right

    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid:
            return 0

        count = 0

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    count += 1
                    self.updateIsland(grid, i, j)

        return count
