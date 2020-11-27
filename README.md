# PaytmLabs SDE Challenge

## Coding Question

Write an interface for a data structure that can provide the moving average of the last N elements added, add elements to the structure and get access to the elements. Provide an efficient implementation of the interface for the data structure.

### Minimum Requirements

1. Provide a separate interface (IE `interface`/`trait`) with documentation for the data structure
2. Provide an implementation for the interface
3. Provide any additional explanation about the interface and implementation in a README file.

## Coding Solution
1. Interface name MovingAverage
2. Implementation  MovingAverageArrayListImpl and MovingAverageLinkedListImpl
3. Additional details about Implementation are as below: 
   ````
   a) Current Implementation is not Thread safe
   d) Problem with ArrayList implementation that underlying array keeps growing. For LinkedList based 
      implementation we remove the first Element when we have more elements than sample size. But With LinkedList implementation
      it takes more time to access the elements form o(1) for ArrayList to O(n) for linkedList.
   e) Test class is also added with few test cases.
   f) While returning moving average, I have used a scale of 2. So all results will be up to 2 decimal places. Rounding mode is HALF_EVEN.
   g) Another Improvement is to add boundary value checks for get() method used to fetch elements by index. 
   

## Design Question

Design A Google Analytic like Backend System.
We need to provide Google Analytic like services to our customers. Please provide a high level solution design for the backend system. Feel free to choose any open source tools as you want.

### Requirements

1. Handle large write volume: Billions of write events per day.
2. Handle large read/query volume: Millions of merchants wish to gain insight into their business. Read/Query patterns are time-series related metrics.
3. Provide metrics to customers with at most one hour delay.
4. Run with minimum downtime.
5. Have the ability to reprocess historical data in case of bugs in the processing logic.

## Design Solution
Design Solution doc path '/design_solution/DesignSolution.docx'