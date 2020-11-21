### 1. Dependency Structure Matrix

# How to generate a DSM from IntellJ you need to:
- 1. Make sure you have the Dependency Structure Matrix plugin installed: `> Ctrl+Alt+S > Plugins > Confirm 'Dependency Structure Matrix' under 'Instaled' tab.`
- 2. Generate the matrix: `> RMB in the module > Analyse > Dependency Structure Matrix` 

# Result for quizzes-tutor-backend:
<img src="pictures/DSM.png" width="800" >

# How to interpret this DSM (based on the picture):
- the `user` module depends on the `impexp` module with a strength of 84.
- the `impexp` module depends on the `user` module with a strength of 9.
- you can expand each part of the matrix to know exactly, down to method level, where these dependencies are.
