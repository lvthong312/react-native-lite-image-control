import { StyleSheet, View } from 'react-native';

// ✅ 1. Preload trước các ảnh — Glide sẽ tải sẵn vào cache disk/memory.
// preload([
//   'https:/333.png',
//   'https:/334.png',
//   'https:/335.png',
// ]);

// ✅ 2. Lấy toàn bộ danh sách cache hiện có (Glide disk cache)
// getAllCache().then((value) => {
//   console.log('Get All Cache:', value);
// });

// ✅ 3. Sau 5s — Xoá cache trên đĩa
// setTimeout(() => {
//   clearDiskCache();
//   console.log('Clear Disk Cache');
// }, 5000);

// ✅ 4. Sau 11s — Kiểm tra lại cache (sẽ thấy cache trống hoặc giảm)
// setTimeout(() => {
//   getAllCache().then((value) => {
//     console.log('Get All Cache Clear', value);
//   });
// }, 11000);

export default function App() {
  return <View style={styles.container}></View>;
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
});
