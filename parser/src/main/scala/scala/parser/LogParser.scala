package scala.parser

import scala.io.Source

import scala.reflect.io.File
import java.io._
import java.io.File
import scala.collection.mutable.ListBuffer
import scala.io.StdIn

object   LogParser {
  def main(args: Array[String]): Unit = {
  // filename est le path danslequel j'ai mis le fichier Log Input
  val filename = "C:/Users/wissem/Desktop/LogParser/tornik-map-20171006.10000.tsv"
  /* file est le path de fichier danslequel je vais mettre le premier resultat 
     * 	: les lignes qui correspond aux tuiles valables */
  val file = "C:/Users/wissem/Desktop/LogParser/output.txt"
val writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))
  
  //for (line <- Source.fromFile(filename).getLines) {
  var line = ""
  while ({line = StdIn.readLine(); line != null}){
  val ch = line.split("\t")(1)
    if(!ch.isEmpty){
   // println(ch)
      writer.write(ch+"\n")
}
}
   writer.close()
  var cpt = 0 
 var viewmodes = new ListBuffer[String]()
  for (line <- Source.fromFile(file).getLines) {
    val tab = (line.split("/"))
    var tt = tab(6)
    val ch = tab(4)
    if (tab(1) == "map" & tab(2) == "1.0" & tab(3) == "slab"){
     viewmodes += tab(4)
  //  println( tab(4)  + "\t" + tab(6) ) 
     //viewmodes.foreach(println)
      for (viewmode <- viewmodes){
        if (viewmode == ch){
          cpt += 1
          if (cpt > 1) tt == tt + "," + tab(6)
          println(viewmode + "\t" + cpt + "\t" + tt)
        }
        else cpt = 1 
        ch == tab(4)
      }
    }
  }
}
}