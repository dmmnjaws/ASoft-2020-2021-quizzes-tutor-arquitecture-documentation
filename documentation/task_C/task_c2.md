## **C2**  Create scenarios for the identified QAs

### Modifiability scenario for **BG1**
- `Source` : The teacher
- `Stimulus` : Create a new question with the purpose of being reused in the future
- `Artifacts` : The question asset
- `Environment` : Design time
- `Response` : Create the asset and deploy it
- `Response Measure` : Number of uses of asset. Time to create the asset

### Availability scenario for **BG1**
- `Source` : Internal fault
- `Stimulus` : A student submission to the quizz did not appear due to DB malfunction
- `Artifacts` : Database
- `Environment` : Normal operation 
- `Response` : Log the fault
- `Response Measure` : Time to detect the fault. Time to repair the fault

### Availability scenario for **BG2**
- `Source` : Internal fault
- `Stimulus` : A student submission to the discussion did not appear due to DB malfunction
- `Artifacts` : Database
- `Environment` : Normal operation 
- `Response`: Log the fault
- `Response Measure`: Time to detect the fault. Time to repair the fault

### Modifiability scenario for **BG3**
- `Source` : The student
- `Stimulus` : Divide a many responsabilities module into single responsability modules
- `Artifacts` : A specific module
- `Environment` : Design time
- `Response` : Make the change, test it, and deploy it
- `Response Measure` : Time to implement the change. Number of interfaces created between the newly created modules and the rest of the application. Number of cyclic dependencies created. Effect on other Quality Attributes


----------------


### Old considerations

### Reusability scenario for BG1
- Source: The student
- Stimulus: Create a new question with the purpose of being reused in the future
- Artifacts: The question asset
- Environment: Design time
- Response: Create the asset and deploy it
- `Response Measure`: Number of uses of asset. Time to create the asset.

### Extensibility scenario for BG2
- Source: The student
- Stimulus: Request to add a new function
- Artifacts: A specific module
- Environment: Design time
- Response: Create the function, test it, and deploy it
- `Response Measure`: Time to implement the function. Number of modules or other artifacts affected. Effect on other Quality Attributes.

### Availability scenario for BG2
- Source: Internal fault
- Stimulus: A student submission to the discussion did not appear due to DB malfunction
- Artifacts: DB
- Environment: Normal operation 
- Response: Log the fault. 
- `Response Measure`: Time to detect the fault. Time to repair the fault.

### Modularity scenario for BG3
- Source: The student
- Stimulus: Divide a many responsabilities module into single responsability modules
- Artifacts: A specific module
- Environment: Design time
- Response: Make the change, test it, and deploy it
- `Response Measure`: Time to implement the change. Number of interfaces created between the newly created modules and the rest of the application. Number of cyclic dependencies created. Effect on other Quality Attributes.




