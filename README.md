This repository has been created with helps of Akın Tatar , Ozan Ergüleç , Seher Oğuz
*************************************************************************************
The computation of fundamental graph parameters such as radius, diameter,
and eccentricities in distributed graphs presents a challenging problem with
widespread implications in various fields, including network analysis, distributed
systems, and social network analysis
*************************************************************************************
This repository contains :
1) an example of Graph Edge Vertex data structures implementation,
2) a distributed algorithm for simultaneous computation of the
diameter (D), radius (R), and node eccentricity (ecc(i)) in all nodes of a network.

Early acquisition of this topological information proves valuable as it serves as
input for various algorithms. For instance, the diameter or eccentricity aids in
simplifying termination in leader election algorithms and calibrating time-to-live
parameters, while the radius and eccentricity facilitate the identification of center
nodes, which are optimal for coordinating other distributed algorithms.
------------------------------------------------------------------------------------
You can reach the distributed algorithms : 
# 1)  calculateEccentricity()
# 2) calculateDiameter()
# 3) calculateRadius()
