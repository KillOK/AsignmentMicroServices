LibraryApp.controller("genreController", function($scope, $http,
		libraryService, libConstants, $window, $location) {

	if ($location.path() === '/addgenre') {
		libraryService.initGenre(
				libConstants.ADMIN_RS_HOST + libConstants.INIT_GENRE).then(
				function(result) {
					console.log($location.path());
					$scope.genre = result;
				});
		
		libraryService.getAll(
				libConstants.ADMIN_RS_HOST + libConstants.READ_ALL_BOOKS).then(
				function(result) {
					$scope.books = result;
				});
		
    $scope.$watch('selected', function(nowSelected){
	        
	        if( ! nowSelected ){
			    // if not selected then return
	            return;
	        }
	        angular.forEach(nowSelected, function(val){
	            $scope.selectedBooks.push( val );
	        });
	        	
	    });
	    
	} else {
		libraryService.getAll(
				libConstants.ADMIN_RS_HOST + libConstants.READ_ALL_GENRES).then(
				function(result) {
					console.log($location.path());
					$scope.genres = result;
				});
	}
 

	$scope.saveGenre = function() {
		if($scope.selectedBooks!=null&&$scope.genre.books==null){
			console.log($scope.genre.books);
			console.log($scope.selectedBooks);
			$scope.genre.books=$scope.selectedBooks;
		}
		libraryService.postObj(
				libConstants.ADMIN_RS_HOST + libConstants.GENRE_CRUD,
				$scope.genre).then(function(result) {
			$scope.genres = result;
			$window.location = "#/genresCRUD"
		});
    };
    
    

	$scope.deleteGenre = function(genreId) {
		var genreToDelete = {
			"genreId" : genreId
		};
		libraryService.postObj(
				libConstants.ADMIN_RS_HOST + libConstants.GENRE_CRUD,
				genreToDelete).then(function(result) {
			$scope.genres = result;
		});
	}
	
	

});