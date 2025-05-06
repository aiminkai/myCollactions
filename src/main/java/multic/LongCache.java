package multic;

import java.util.concurrent.atomic.AtomicReference;

public class LongCache {
    private static final int CACHE_SIZE = 10;

    // Двойной буфер для хранения данных
    private static class CacheHolder {
        final long[] data = new long[CACHE_SIZE];
    }

    private final AtomicReference<CacheHolder> currentCache = new AtomicReference<>(new CacheHolder());

    // Интерфейс для обновления кэша
    public interface Updater {
        void update(long[] data);
    }

    // Блокирующее обновление кэша
    public synchronized void bulkUpdate(Updater updater) {
        // Создаем новый буфер
        CacheHolder newCache = new CacheHolder();
        // Копируем текущие данные
        System.arraycopy(currentCache.get().data, 0, newCache.data, 0, CACHE_SIZE);
        // Применяем обновления
        updater.update(newCache.data);
        // Атомарно заменяем ссылку
        currentCache.set(newCache);
    }

    // Неблокирующее чтение из кэша
    public long[] bulkRead(int[] indices) {
        // Получаем текущий буфер (чтение атомарно и thread-safe)
        CacheHolder holder = currentCache.get();
        long[] result = new long[indices.length];

        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            if (index >= 0 && index < CACHE_SIZE) {
                result[i] = holder.data[index];
            }
        }

        return result;
    }
}
