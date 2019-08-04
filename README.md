# Fall2017-Project-MonteCarloSimulation

Computing in Finance(Fall 2017) - Monte Carlo Simulation Project

RECOMMENDS:

	Recommend JRE 1.8
     	Recommend Eclipse for IDE

MY RESULT:

      	Use European call, the value of a call option after 252 days is $6.391238918865717
	The call option should be priced $6.2321921046379. 
	Also, it takes 1280926 times simulation to converge. 
	
      	Use Asian call, the value of a call option after 252 days is $2.251201872994745 
	The call option should be priced $2.1951804207178434. 
	Also, it takes 254026 times simulation to converge. 

INSTRUCTIONS FOR COMPILE:

When the program is compiled in command line:	

	**IMPORTANT**: Before run the program, download the latest joda-time jar file. In Eclipse look the project package and copy/drag joda-time-2.1.jar into it. Right click on the project again then follow the steps to add jars: 襊roperties, Java Build Path, Libraries, Add Jars, joda-time-2.1.jar. 

	**IMPORTANT**: Before run the program, download the latest Mockito mocking-core-2.11.0.jar file and extract its contents. In Eclipse look the project package and copy/drag mocking-core-2.11.0.jar into it. Right click on the project again then follow the steps to add jars: Properties, Java Build Path, Libraries, Add Jars, mocking-core-2.11.0.jar. 
	
	**IMPORTANT**: In order to avoid the execption while using Mockito(Could not initialize plugin: interface org.mockito.plugins.MockMaker), add three additional jars to the program lib. objenesis-2.5.jar, byte-buddy-1.6.5.jar and byte-buddy-agent-1.6.5.jar. These three jar files are available under lib folder of the program.

DESCRIPTION:

* This program is using following Java libraries:

 	- joda-time-2.9.9.jar (url for download: https://mvnrepository.com/artifact/joda-time/joda-time/2.9.9)
 	- mockito-core-2.11.0.jar (url for download: https://mvnrepository.com/artifact/org.mockito/mockito-core/2.11.0)
 	- objenesis-2.5.jar (url for download: https://mvnrepository.com/artifact/org.objenesis/objenesis/2.5)
 	- byte-buddy-1.6.5.jar (url for download: https://mvnrepository.com/artifact/net.bytebuddy/byte-buddy/1.6.5)
	- byte-buddy-agent-1.6.5.jar (url for download: https://mvnrepository.com/artifact/net.bytebuddy/byte-buddy-agent/1.6.5)

 Please Note: When I was using mockito for Junit testing, I've got the "Could not initialize plugin: interface org.mockito.plugins.MockMaker" exception message and couldn't run the JUnit test. I found a solution to it which is adding 3 more libraries(last 3 .jar files) to the program. Details please see url for more detail: https://stackoverflow.com/questions/41956692/could-not-initialize-plugin-interface-org-mockito-plugins-mockmaker

* This program contains three interfaces:

		RandomVectorGenerator interface
		PayOut interface
		StockPath interface

		RandomVectorGenerator interface: This interface of generating the random vectors, the returned double[] should be the vector of standard normally distributed numbers.
		PayOut interface: This interface of calculate the payout, the returned double should be the payout after each simulation.
		StockPath interface: This interface of generating the simulate stock paths, the returned List<DPPoint> should be the list of Date-Price Points. 

* This program contains eight java class files:

		GuassianRandomVeriableGenerator
		AntitheticDecoratorGenerator
		CallOptionPayout
		AsianCallPayout
		BrownianStockPathGenerator
		DPPoint
		StatsCollector
		MonteCarloSimulation

	*GuassianRandomVeriableGenerator: This is the GuassianRandomVeriableGenerator class implementing RandomVariableGenerator interface.

	*AntitheticDecoratorGenerator: This is the AntitheticDecoratorGenerator class implementing RandomVariableGenerator interface.

	*CallOptionPayout: This is the CallOptionPayout class implementing PayOut interface. This class is implementing the European Options payout function by compare 0 with the max value of the last price of the brownianStorckPath simulation subtract the strikePrice.

	*AsianCallPayout: This is the AsianCallPayout class implementing PayOut interface. This class is implementing the Asian Call Options payout function by compare 0 with the average value of the price from the brownianStorckPath simulation subtract the strikePrice.

	*BrownianStockPathGenerator: This is the BrownianStockPathGenerator class implementing StockPath interface. This class will generate a list of DDP objects and we treat them as the simulation of the future stock path.

	*DPPoint: This is the DPPoint class for the objects to store with DateTime value and price for that day. DPPoint stands for "Date-Price Point".

	*StatsCollector: This is the StatsCollector class. This class will keep track of stats of average and standard deviation.

	*MonteCarloSimulation: This is the MonteCarloSimulation class. This is the class of simulation manager and uses 3 inputs to run the simulation and decide when to stop. 

* This program contains four test files:

		GuassianRandomVeriableGeneratorTest
		AntitheticDecoratorGeneratorTest
		DPPointTest
		MonteCarloSimulationTest(This test contains 3 tests: test for AsianCallPayout, EuropeanCallPayout, Brownian Stock Path using Mokito)

*GuassianRandomVeriableGeneratorTest: This test returns the size of the random generate vector. 
*AntitheticDecoratorGeneratorTest: This test returns the size of the decorated random generate vector.
*DPPointTest: This test checks getdateValue method and getPriceValue method. 
*MonteCarloSimulationTest: This test includes three mockito tests, testBrownianPath, testEuropeanCallPayOut and testAsianCallPayOut. 






