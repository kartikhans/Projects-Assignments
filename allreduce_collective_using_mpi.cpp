#include "mpi.h"
#include <iostream>
#include <cmath>
using namespace std;

void adding(int* bvalue, int count, int bw, int* xrvalue, int size){
	for(int i = 0; i<size-(count*bw) && i < bw; i++){
		bvalue[i + count*bw] += xrvalue[i];
	}
}
void broadcast(int* bvalue, int bw, int size, int rank,int pipesize, MPI_Status &status){
  int n = sqrt(pipesize);
  int count = 0;
  for(int count=0;count <= (size-1)/bw;count++){
    if(rank == 0){
      MPI_Send(&bvalue[count*bw],bw,MPI_INT, 1, 1,MPI_COMM_WORLD);
    }
    else{
      int q = rank/n;
      int r = rank%n;
      if(q==0){
        MPI_Recv(&bvalue[count*bw],bw,MPI_INT, rank - 1,1,MPI_COMM_WORLD, &status);
        if(r!=n-1){
          MPI_Send(&bvalue[count*bw],bw,MPI_INT,rank+1,1,MPI_COMM_WORLD);
        }
        MPI_Send(&bvalue[count*bw],bw,MPI_INT, rank+n, 1,MPI_COMM_WORLD);
      }
      else if(r==0){
        MPI_Recv(&bvalue[count*bw],bw,MPI_INT,rank+1,1,MPI_COMM_WORLD, &status);
      }
      else{
        MPI_Recv(&bvalue[count*bw],bw,MPI_INT,rank-n,1,MPI_COMM_WORLD,&status);
        if(q!=n-1){
          MPI_Send(&bvalue[count*bw],bw,MPI_INT,rank+n,1,MPI_COMM_WORLD);

        }
        if(r==1){
          MPI_Send(&bvalue[count*bw],bw,MPI_INT,rank-1,1,MPI_COMM_WORLD);
        }
      }
    }
  }
}
void reduce(int* bvalue,int bw,int size, int rank, int pipesize, MPI_Status &status){
  int n = sqrt(pipesize);
  int count = 0;
  int xrvalue[bw];
  for(int count=0;count <= (size-1)/bw;count++){
    if(rank == 0){
      MPI_Recv(xrvalue,bw,MPI_INT,rank+n,1,MPI_COMM_WORLD,&status);
      adding(bvalue,count,bw,xrvalue,size);
    }
    else{
      int q = rank/n;
      int r = rank%n;
      if(r==0){
        MPI_Recv(xrvalue,bw,MPI_INT,rank+1,1,MPI_COMM_WORLD, &status);
        adding(bvalue,count,bw,xrvalue,size);
        if(q!=n-1){
          MPI_Recv(xrvalue,bw,MPI_INT,rank+n,1,MPI_COMM_WORLD,&status);
          adding(bvalue,count,bw,xrvalue,size);
        }
        MPI_Send(&bvalue[count*bw],bw,MPI_INT, rank -n,1, MPI_COMM_WORLD);
      }
      else if(q==0){
        MPI_Send(&bvalue[count*bw],bw, MPI_INT,rank+n,1, MPI_COMM_WORLD);
      }
      else{
        if(q==1){
          MPI_Recv(xrvalue,bw,MPI_INT, rank-n, 1, MPI_COMM_WORLD,&status);
          adding(bvalue,count,bw,xrvalue,size);
        }
        if(r!=n-1){
          MPI_Recv(xrvalue,bw,MPI_INT,rank+1,1,MPI_COMM_WORLD, &status);
          adding(bvalue,count,bw,xrvalue,size);
        }
        MPI_Send(&bvalue[count*bw],bw,MPI_INT,rank-1,1,MPI_COMM_WORLD);
      }
    }
  }
}
void allreduce(int* bvalue, int bw,int size, int rank, int pipesize, MPI_Status &status){
	reduce(bvalue, bw, size,rank, pipesize, status);
	broadcast(bvalue, bw, size,rank, pipesize, status);
}
int main(int argc, char** argv){
	MPI_Init(&argc, &argv);
	MPI_Status status;
	int pipesize;
	MPI_Comm_size(MPI_COMM_WORLD, &pipesize);
	int rank;
	MPI_Comm_rank(MPI_COMM_WORLD, &rank);
	int size = 6300;
	int bw = 7;
	int bvalue[size];
	for(int i = 0; i< size; i++){
		bvalue[i] = 1;
	}
	broadcast(bvalue, bw, size, rank, pipesize, status);


	cout<< rank <<":" << bvalue[0] <<" " << bvalue[(size - 1)/2]<< endl;

	MPI_Finalize();
}
