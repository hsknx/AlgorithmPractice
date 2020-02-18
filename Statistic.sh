
echo "代码量统计"

Algorithm=$(find ./java/Algorithm/     -iname "*.java" |grep -v Test |wc -l)
DataStructure=$(find ./java/DataStructure/ -iname "*.java" |grep -v Test |wc -l)
Logic=$(find ./java/Logic/         -iname "*.java" |grep -v Test |wc -l)

AlgorithmUT=$(find ./java/UnitTest/algorithmTest     -iname "*.java" |grep  Test |wc -l)
DataStructureUT=$(find ./java/UnitTest/datastructureTest -iname "*.java" |grep  Test |wc -l)
LogicUT=$(find ./java/UnitTest/logicTest        -iname "*.java" |grep  Test |wc -l)


Total=$((Algorithm+DataStructure+Logic))
TotalUT=$((AlgorithmUT+DataStructureUT+LogicUT))
echo "       Total  - Algorithm  - DataStructure  -  Logic"
echo "Code:  $Total    -    $Algorithm      -    $DataStructure          -    $Logic"
echo "UT  :  $TotalUT     -    $AlgorithmUT      -    $DataStructureUT          -    $LogicUT"
