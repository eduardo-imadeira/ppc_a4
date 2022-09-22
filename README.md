###  Parallel and Concurrent Programming Course
#### 4th Assignment


In this assignment, you are to develop a batch renaming tool that takes a given directory, a string to be replaced and the string to replace it. This tool will rename all the files and folders according to that rule.

Example of a file system:

root/folder_01/file_01.txt
root/folder_01/file_02.txt
root/folder_02/file_01.txt
root/folder_02/file_02.txt
By invoking your tool with the folder root, the string to be replaced 01 and the string to replace it 13, the output of the directory should be:

root/folder_13/file_13.txt
root/folder_13/file_02.txt
root/folder_02/file_13.txt
root/folder_02/file_02.txt
You should build your too using either Co-routines or the Actor Model in any language you choose. Remember the importance of the report in explaining the architecture and all your decisions.

Note that all the reads from folders can be parallelized, all writes (including creating directories, renaming or moving files and deleting directories) should be sequentialized. Your program should enforce this behavior using the Coroutines or Actor model.

Grade 18/20