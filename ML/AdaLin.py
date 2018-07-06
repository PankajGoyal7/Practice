	# -*- coding: utf-8 -*-
# @Author: Pankaj Goyal
# @Date:   2018-03-13 22:27:33
# @Last Modified by:   Pankaj Goyal
# @Last Modified time: 2018-03-18 16:31:43
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from matplotlib.colors import ListedColormap

class AdalineGD(object):
	def __init__(self,eta=0.01,n_iter=10):
		self.eta = eta
		self.n_iter = n_iter

	def fit(self,X,y):
		self.w_ = np.zeros(1+X.shape[1])
		self.cost_ = []

		for i in range(self.n_iter):
			output  = self.net_input(X)
			errors = (y-output)
			self.w_[1:] +=  self.eta * X.T.dot(errors)
			self.w_[0] += self.eta * errors.sum()
			cost = (errors**2).sum()/2.0
			self.cost_.append(cost)
		return self

	def net_input(self,X):
		return np.dot(X,self.w_[1:])+self.w_[0]

	def activation(self,X):
		return self.net_input(X)

	def predict(self,X):
		return np.where(self.activation(X) >= 0.0,1,-1)

df = pd.read_csv('https://archive.ics.uci.edu/ml/machine-learning-databases/iris/iris.data', header=None)

y = df.iloc[0:100,4].values
y = np.where(y == 'Iris-setosa',-1,1)
X = df.iloc[0:100,[0,2]].values

X_std = np.copy(X)

# fig,ax =  plt.subplots(nrows = 1,ncols=2,figsize=(12,8))
# adal = AdalineGD(eta=0.01,n_iter=10).fit(X,y)
# ax[0].plot(range(1,len(adal.cost_)+1),np.log10(adal.cost_),marker='o')
# ax[0].set_xlabel('Epochs')
# ax[0].set_ylabel('log(Sum-squared-error)')
# ax[0].set_title('Adaline - Learning rate 0.01')

# adal2 = AdalineGD(eta=0.0001,n_iter=10).fit(X,y)
# ax[1].plot(range(1,len(adal2.cost_)+1),np.log10(adal2.cost_),marker='o')
# ax[1].set_xlabel('Epochs')
# ax[1].set_ylabel('log(Sum-squared-error)')
# ax[1].set_title('Adaline - Learning rate 0.0001')

X_std[:,0] = (X[:,0] - X[:,0].mean())/X[:,0].std()
X_std[:,1] = (X[:,1] - X[:,1].mean())/X[:,1].std()

def plot_decisio_regions(X,y,classifier,resolution=0.1):
	markers = ('s','x','o','^','v')
	colors = ('red','blue','lightgreen','gray','cyan')
	cmap = ListedColormap(colors[:len(np.unique(y))])

	x1_min,x1_max = X[:,0].min() - 1,X[:,0].max()+1
	x2_min,x2_max = X[:,1].min() - 1,X[:,1].max()+1
	xx1,xx2 = np.meshgrid(np.arange(x1_min,x1_max,resolution),np.arange(x2_min,x2_max,resolution))
	z = classifier.predict(np.array([xx1.ravel(),xx2.ravel()]).T)
	z = z.reshape(xx1.shape)
	plt.contourf(xx1,xx2,z,alpha=0.4,cmap = cmap)
	plt.xlim(xx1.min(),xx1.max())
	plt.ylim(xx2.min(),xx2.max())

	for idx,cl in enumerate(np.unique(y)):
		plt.scatter(x=X[y==cl,0],y=X[y==cl,1],alpha=0.8,c=cmap(idx),marker=markers[idx],label=cl)

adal3 = AdalineGD(eta=0.01,n_iter=10).fit(X_std,y)
plot_decisio_regions(X_std,y,classifier=adal3)
plt.title('Adaline - Gradient Descent')
plt.xlabel('sepal length [cm]')
plt.ylabel('petal length [cm]')
plt.legend(loc='upper left')
plt.show()


plt.plot(range(1,len(adal3.cost_)+1),adal3.cost_,marker='o')
plt.xlabel('Epochs')
plt.ylabel('Sum-squared-error')
plt.show()


