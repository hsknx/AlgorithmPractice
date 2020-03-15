
echo "Algorithm代码量统计"
dirpath=/d/workspace/AlgorithmPractice/java

Algorithm=$(find  $dirpath/Algorithm/     -iname "*.java" |grep -v Test |wc -l)
DataStructure=$(find $dirpath/DataStructure/ -iname "*.java" |grep -v Test |wc -l)
Logic=$(find $dirpath/Logic/  -iname "*.java" |grep -v Test |wc -l)

AlgorithmUT=$(find $dirpath/UnitTest/algorithmTest     -iname "*.java" |grep  Test |wc -l)
DataStructureUT=$(find $dirpath/UnitTest/datastructureTest -iname "*.java" |grep  Test |wc -l)
LogicUT=$(find $dirpath/UnitTest/logicTest        -iname "*.java" |grep  Test |wc -l)


Total=$((Algorithm+DataStructure+Logic))
TotalUT=$((AlgorithmUT+DataStructureUT+LogicUT))
echo "       Total  - Algorithm  - DataStructure  -  Logic"
echo "Code:  $Total    -    $Algorithm      -    $DataStructure          -    $Logic"
echo "UT  :  $TotalUT     -    $AlgorithmUT      -    $DataStructureUT          -    $LogicUT"
