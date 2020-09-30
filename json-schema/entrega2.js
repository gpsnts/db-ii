// a)
// db.getCollecion("movies")
db.collection.aggregate([
  {
    "$project": {
      _id: 1,
      original_title: 1,
      popularity: 1
    }
  },
  {
    "$sort": {
      popularity: -1
    }
  }
])

// b)
